package org.fundacionview.sgsst.controladores;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.fundacionview.sgsst.modelos.Ausentismo;
import org.fundacionview.sgsst.modelos.CIE10;
import org.fundacionview.sgsst.modelos.Empleado;
import org.fundacionview.sgsst.modelos.Usuario;
import org.fundacionview.sgsst.repositorios.Repo_Ausentismos;
import org.fundacionview.sgsst.repositorios.Repo_Cie10;
import org.fundacionview.sgsst.repositorios.Repo_Empleados;
import org.fundacionview.sgsst.repositorios.Repo_Usuarios;
import org.fundacionview.sgsst.util.AusentismoExporterExcel;
import org.fundacionview.sgsst.util.AusentismoExporterPDF;
import org.fundacionview.sgsst.util.EmpleadoExporterExcel;
import org.fundacionview.sgsst.util.EmpleadoExporterPDF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lowagie.text.DocumentException;

@Controller
public class ControladorPpal {
	
	
	@Autowired
	Repo_Cie10 repoDiagnosticos;
	
	
	@Autowired
	Repo_Empleados repoEmple;
	
	
	@Autowired
	Repo_Ausentismos repoAusenti;
	
	
	
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(
	            dateFormat, false));
	}
	
	
	@GetMapping({"/","/home"})
	public String index() {
						
		return "redirect:/listar";
	}
	
	
	@GetMapping("/crear")
	public String formEmpleado(Model mod) {
		
		mod.addAttribute("emp",new Empleado());
		return "crearempleado";
	}
	
	
	@PostMapping("/crear_empleado")
	public String guardarEmpleado(@Valid @ModelAttribute("emp")Empleado e,Model mod,BindingResult rv) {
		
		if(rv.hasErrors()) {
			return "crearempleado";
		}else {		
			
			repoEmple.save(e);
		    return "redirect:/listar";
		}
	}
	
	
	@GetMapping("/listar")
	public String listar(Model mod) {
		
		mod.addAttribute("listaEmpleados",repoEmple.findAll());
		return "listar";
	}
	
	@GetMapping("/exportar_pdf")
	public void exportarListadoDeEmpleadosEnPDF(HttpServletResponse response, Model mod) throws DocumentException, IOException {
		response.setContentType("application/pdf");
		
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String fechaActual = dateFormatter.format(new Date());
		
		String cabecera = "Content-Disposition";
		String valor = "attachment; filename=Empleados_" + fechaActual + ".pdf";
		
		response.setHeader(cabecera, valor);
		
		mod.addAttribute("listaEmpleados",repoEmple.findAll());
		
		@SuppressWarnings("unchecked")
		List<Empleado> empleados = (List<Empleado>) mod.getAttribute("listaEmpleados");		
				
		EmpleadoExporterPDF exporter = new EmpleadoExporterPDF(empleados);
		exporter.exportar(response);
	}
		

	@GetMapping("/exportar_excel")
	public void exportarListadoDeEmpleadosEnExcel(HttpServletResponse response, Model mod) throws DocumentException, IOException {
		response.setContentType("application/octet-stream");
		
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String fechaActual = dateFormatter.format(new Date());
		
		String cabecera = "Content-Disposition";
		String valor = "attachment; filename=Empleados_" + fechaActual + ".xlsx";
		
		response.setHeader(cabecera, valor);						
		
		mod.addAttribute("listaEmpleados",repoEmple.findAll());
		
		@SuppressWarnings("unchecked")
		List<Empleado> empleados = (List<Empleado>) mod.getAttribute("listaEmpleados");		
				
		EmpleadoExporterExcel exporter = new EmpleadoExporterExcel(empleados);
		exporter.exportar(response);
		
	}
	
	@GetMapping("/crearInc")
	public String crearIncapacidad(Model mod) {
		
		mod.addAttribute("ausentismo",new Ausentismo());
		return "crearIncapacidad";
	}
	
	
	@PostMapping("/crearIncapacidad")
	public String guardarIncapacidad(@Valid @ModelAttribute("ausentismo")Ausentismo a,Model mod,BindingResult rv) {
		
		if(rv.hasErrors()) {
			return "crearIncapacidad";
		}else {
		
			Empleado e=repoEmple.consultarCC(a.getNumID());
			
			
		//	a.setNombre(null);
		//	a.setApellidos(null)
			a.setAreaTrabajo(e.getAreaTrabajo());
			a.setApellidos(e.getApellidos());
			a.setTipoID(e.getTipoID());
			
			
			double totales[]=calcularPagos(a.getTipoIncapacidad(), a.getTotalDias(), a.getSalarioDia());
			
			a.setValorARL(totales[1]);
			a.setValorEmpresa(totales[0]);
			a.setValorEPS(totales[2]);
			a.setValorPensiones(totales[3]);
			a.setFechaRegistro(new Date());
			//			
			a.setDiagnostico(repoDiagnosticos.findByCodigo(a.getCodigoDiagnosti()).get());
			
			repoAusenti.save(a);
		return "redirect:/listarIncapacidad";
		}
	}
	

	public double[] calcularPagos(String tipoIncapacidad,int totalDias,double valorDias) {
		double[] valores=new double[4];  // 0= ValorEmpresa, 1= ValorARL, 2= ValorEPS, 3=ValorPensiones.
	
		
		
		if(tipoIncapacidad.equals("Enfermedad Comun")) {
			if(totalDias<3) {
				valores[0]=totalDias*valorDias;
				valores[1]=0.0;
				valores[2]=0.0;
				valores[3]=0.0;
				
			}else if(totalDias<=180) {
				
				valores[0]=2*valorDias;
				valores[1]=0.0;
				valores[2]=(totalDias-2)*valorDias*0.6667;
				valores[3]=0.0;
				
				
			}else if(totalDias<=540) {
				
				valores[0]=2*valorDias;
				valores[1]=0.0;
				valores[2]=(178)*valorDias*0.6667;
				valores[3]=(totalDias-180)*valorDias*0.5;
				
			}else {
				valores[0]=2*valorDias;
				valores[1]=0.0;
				valores[2]=((178)*valorDias*0.6667)+((totalDias-540)*valorDias*0.5);
				valores[3]=(540-180)*valorDias*0.5;
				
			}
			
			
			
			
			
		
		}else if(tipoIncapacidad.equals("Lic. Maternidad")) {
			
			valores[0]=0.0;
			valores[1]=0.0;
			valores[2]=totalDias*valorDias;
			valores[3]=0.0;
			
			
		
		}else if(tipoIncapacidad.equals("Lic. Paternidad")) {
			
			
			valores[0]=0.0;
			valores[1]=0.0;
			valores[2]=totalDias*valorDias;
			valores[3]=0.0;
			
			
		}else if(tipoIncapacidad.equals("Enfermedad Laboral")) {
			
			valores[0]=0.0;
			valores[1]=totalDias*valorDias;
			valores[2]=0.0;
			valores[3]=0.0;
			
			
		}else if(tipoIncapacidad.equals("Accidente de trabajo")) {
			valores[0]=0.0;
			valores[1]=totalDias*valorDias;
			valores[2]=0.0;
			valores[3]=0.0;
			
		}else if(tipoIncapacidad.equals("Fondo Pensiones")) {
			
			
			
		}else if(tipoIncapacidad.equals("Accedente de Transito")) {
			
			if(totalDias<3) {
				valores[0]=totalDias*valorDias;
				valores[1]=0.0;
				valores[2]=0.0;
				valores[3]=0.0;
			}else {
				valores[0]=2*valorDias;
				valores[1]=(totalDias-2)*valorDias*0.67;
				valores[2]=0.0;
				valores[3]=0.0;
			}
			
		}
				
		
		return valores;
	}
	
	
	@GetMapping("/listarIncapacidad")
	public String listarInca(Model mod) {
		
		mod.addAttribute("listaIncapacidades",repoAusenti.findAll());
		return "listarIncapacidad";
	}
	
	@GetMapping("/exportar_ausentismo_pdf")
	public void exportarListadoDeAusentismoEnPDF(HttpServletResponse response, Model mod) throws DocumentException, IOException {
		response.setContentType("application/pdf");
		
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String fechaActual = dateFormatter.format(new Date());
		
		String cabecera = "Content-Disposition";
		String valor = "attachment; filename=Ausentismo_" + fechaActual + ".pdf";
		
		response.setHeader(cabecera, valor);
		
		mod.addAttribute("listaIncapacidades",repoAusenti.findAll());

		@SuppressWarnings("unchecked")
		List<Ausentismo> incapacidades = (List<Ausentismo>) mod.getAttribute("listaIncapacidades");		
				
		AusentismoExporterPDF exporter = new AusentismoExporterPDF(incapacidades);
		exporter.exportar(response);
	}
		
	@GetMapping("/exportar_ausentismo_excel")
	public void exportarListadoDeAusentismoEnExcel(HttpServletResponse response, Model mod) throws DocumentException, IOException {
		response.setContentType("application/octet-stream");
		
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String fechaActual = dateFormatter.format(new Date());
		
		String cabecera = "Content-Disposition";
		String valor = "attachment; filename=Ausentismo_" + fechaActual + ".xlsx";
		
		response.setHeader(cabecera, valor);						
		
		mod.addAttribute("listaIncapacidades",repoAusenti.findAll());
		
		@SuppressWarnings("unchecked")
		List<Ausentismo> incapacidades = (List<Ausentismo>) mod.getAttribute("listaIncapacidades");		
				
		AusentismoExporterExcel exporter = new AusentismoExporterExcel(incapacidades);
		exporter.exportar(response);
		
	}
	
	
	@GetMapping("/eliminarEmpleado")
	public String eliminarEmpleado(Model mod,@RequestParam("id")Long id) {
		
		repoEmple.deleteById(id);
		
		return "redirect:/listar";
	}
	
	
	@GetMapping("/eliminarInc")
	public String eliminarInc(Model mod,@RequestParam("id")int id) {
		
		repoAusenti.deleteById(id);
		
		return "redirect:/listarIncapacidad";
	}
	
	
	@GetMapping("editarE")
	public String editarE(Model mod,@RequestParam("id")Long id) {
		
		
		//mod.addAttribute("empleado",repoEmple.getById(id));
		
		mod.addAttribute("emp",repoEmple.getById(id));
		return "editarempleado";
	}
	
	
	@GetMapping("editarI")
	public String editarI(Model mod,@RequestParam("id")int id) {
		
		
		//mod.addAttribute("empleado",repoEmple.getById(id));
		mod.addAttribute("ausentismo",repoAusenti.findById(id).get());
		return "editarIncapacidad";
	}
	
	@Autowired
	Repo_Usuarios repoUsu;
	
	@GetMapping("/crearUser")
	public String crearUser(Model mod,@RequestParam("id")Long id) {
		
		Usuario u=repoUsu.buscarPorId_Empleado(id);
		
		if(u!=null) {			
			// Editar Usuario
			
			mod.addAttribute("usuario",u);
			mod.addAttribute("editar",true);
			mod.addAttribute("titulo","Editar Usuario del empleado "+u.getEmpUnoaUno().getNombre());
			return "crearUsuario";
			
		}else {			
			// Crear Usuario
			
			Empleado e=repoEmple.getById(id);
			
			Usuario uu=new Usuario();
			uu.setEmpUnoaUno(e);
			mod.addAttribute("usuario",uu);
			mod.addAttribute("editar",false);
			mod.addAttribute("titulo","Crear Usuario del empleado "+e.getNombre());
			return "crearUsuario";
			
		}
		
		
	}
	
	@PostMapping("/crear_usuario")
	public String guardarUsuario(@Valid @ModelAttribute("usuario")Usuario u,Model mod,BindingResult rv) {
		
		if(rv.hasErrors()) {
			return "crearUsuario";
		}else {
		
			u.setCreateDate(new Date());
			u.setLastInDate(new Date());
			
			repoUsu.save(u);
			
			return "redirect:/listar";
		}
	}
	
	@GetMapping("/listaUsuarios")
	public String listarUsuarios(Model mod) {
		
		mod.addAttribute("listaUsuarios",repoUsu.findAll());
		return "listarUsuarios";
	}
	
	  
	@GetMapping("/reporteAreas")
	public String reporteAreas(Model mod) {
		
		
		return "reportesArea";
	}
	
	
	@PostMapping("/reporteArea")
	public String generarReporteAreas(Model mod,@RequestParam("area")String area,@RequestParam("fechaInicial")Date fechaIni,@RequestParam("fechaFinal")Date fechaFin) {
		
		
		
		//mod.addAttribute("listaIncapacidades",repoAusenti.findByAreaTrabajo(area));
		mod.addAttribute("listaIncapacidades",repoAusenti.consultaConfechas(area,fechaIni,fechaFin));
		return "ReportesIncapacidad";
	}
	
	
	@GetMapping("/reporteEmpleado")
	public String reporteEmpleado() {
		return "reporteEmpleado";
	}
	
	@PostMapping("/reporteEmpleado")

	public String generarReporteEmpleados(Model mod,@RequestParam("numDoc")Long numDoc,@RequestParam("nombre")String nombre) {
		
		mod.addAttribute("listaIncapacidades",repoAusenti.findAll());
		mod.addAttribute("titulo",nombre);
		return "tableReporteEmpleados";
	}
	
	@GetMapping("/reporteTipo")
	public String reporteTipo() {
		return "reporteTipo";
	}
	
	@PostMapping("/reporteTipo")
	public String generarReporteTipo(Model mod,@RequestParam("tipoIncapacidad")String tipo) {
		
		
		mod.addAttribute("listaIncapacidades",repoAusenti.findAll());
		mod.addAttribute("area",tipo);
		return "tableReporteTipo";
	}
	
	@GetMapping("/reporteCuentas")
	public String reporteCuentas() {
		return "reporteCuentas";
	}
	
	
	@PostMapping("/reporteCuentas")
	public String generarReporteCuentas(Model mod,@RequestParam("fechaIn")Date fechaIn,@RequestParam("fechaFin")Date fechaFin) {
		
		
		mod.addAttribute("listaIncapacidades",repoAusenti.consultaCuentas(fechaIn,fechaFin));
		mod.addAttribute("fechas","Entre "+fechaIn.toString()+" y "+fechaFin.toString());
		return "tableReporteCuentas";
	}
	
}
