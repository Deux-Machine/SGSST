package org.fundacionview.sgsst.util;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;
import org.fundacionview.sgsst.modelos.Empleado;



public class EmpleadoExporterExcel {

	private XSSFWorkbook libro;
	private XSSFSheet hoja;

	private List<Empleado> listaEmpleados;

	public EmpleadoExporterExcel(List<Empleado> listaEmpleados) {
		this.listaEmpleados = listaEmpleados;
		libro = new XSSFWorkbook();
		hoja = libro.createSheet("Empleados");
	}

	private void escribirCabeceraDeTabla() {
		Row fila = hoja.createRow(0);
		
		CellStyle estilo = libro.createCellStyle();
		XSSFFont fuente = libro.createFont();
		fuente.setBold(true);
		fuente.setFontHeight(16);
		estilo.setFont(fuente);
		
		Cell celda = fila.createCell(0);
		celda.setCellValue("ID");
		celda.setCellStyle(estilo);
		
		celda = fila.createCell(1);
		celda.setCellValue("Nombre");
		celda.setCellStyle(estilo);
		
		celda = fila.createCell(2);
		celda.setCellValue("Apellido");
		celda.setCellStyle(estilo);
		
		celda = fila.createCell(3);
		celda.setCellValue("Cargo");
		celda.setCellStyle(estilo);
		
		celda = fila.createCell(4);
		celda.setCellValue("Documento");
		celda.setCellStyle(estilo);
		
		celda = fila.createCell(5);
		celda.setCellValue("Tipo Doc");
		celda.setCellStyle(estilo);
		
		celda = fila.createCell(6);
		celda.setCellValue("Area");
		celda.setCellStyle(estilo);
		
		celda = fila.createCell(7);
		celda.setCellValue("Salario");
		celda.setCellStyle(estilo);
	}
	
	private void escribirDatosDeLaTabla() {
		int nueroFilas = 1;
		
		CellStyle estilo = libro.createCellStyle();
		XSSFFont fuente = libro.createFont();
		fuente.setFontHeight(14);
		estilo.setFont(fuente);
		
		for(Empleado empleado : listaEmpleados) {
			Row fila = hoja.createRow(nueroFilas ++);
			
			Cell celda = fila.createCell(0);
			celda.setCellValue(empleado.getId());
			hoja.autoSizeColumn(0);
			celda.setCellStyle(estilo);
			
			celda = fila.createCell(1);
			celda.setCellValue(empleado.getNombre());
			hoja.autoSizeColumn(1);
			celda.setCellStyle(estilo);
			
			celda = fila.createCell(2);
			celda.setCellValue(empleado.getApellidos());
			hoja.autoSizeColumn(2);
			celda.setCellStyle(estilo);
			
			celda = fila.createCell(3);
			celda.setCellValue(empleado.getCargo());
			hoja.autoSizeColumn(3);
			celda.setCellStyle(estilo);
			
			celda = fila.createCell(4);
			celda.setCellValue(empleado.getNumID());
			hoja.autoSizeColumn(4);
			celda.setCellStyle(estilo);
			
			celda = fila.createCell(5);
			celda.setCellValue(empleado.getTipoID());
			hoja.autoSizeColumn(5);
			celda.setCellStyle(estilo);
			
			celda = fila.createCell(6);
			celda.setCellValue(empleado.getAreaTrabajo());
			hoja.autoSizeColumn(6);
			celda.setCellStyle(estilo);
			
			celda = fila.createCell(7);
			celda.setCellValue(empleado.getSalario());
			hoja.autoSizeColumn(7);
			celda.setCellStyle(estilo);
		}
	}
	
	public void exportar(HttpServletResponse response) throws IOException {
		escribirCabeceraDeTabla();
		escribirDatosDeLaTabla();
		
		ServletOutputStream outPutStream = response.getOutputStream();
		libro.write(outPutStream);
		
		libro.close();
		outPutStream.close();
	}
}
