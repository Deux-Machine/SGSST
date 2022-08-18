package org.fundacionview.sgsst.modelos;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_incapacidad")
public class Ausentismo {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	

	private String nombre;
	private String apellidos;
	private String tipoID;
	private String numID;
	private String areaTrabajo;
	
	
	public String getAreaTrabajo() {
		return areaTrabajo;
	}


	public void setAreaTrabajo(String areaTrabajo) {
		this.areaTrabajo = areaTrabajo;
	}
	private String tipoIncapacidad;
	private String cargo;
	private String EPS;
	private int salario;
	private double salarioDia;
	private Date fechaInicial;
	private Date fechaFin;
	private int totalDias;
	private String clasificacion;
	
	private double valorEmpresa;
	private double valorEPS;
	private double valorARL;
	private double valorPensiones;
	
	private Date fechaRegistro;
	
	private String codigoDiagnosti;
	
	
	public Date getFechaRegistro() {
		return fechaRegistro;
	}


	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	
	
	
	public String getCodigoDiagnosti() {
		return codigoDiagnosti;
	}


	public void setCodigoDiagnosti(String codigoDiagnosti) {
		this.codigoDiagnosti = codigoDiagnosti;
	}
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_diagnostico", referencedColumnName = "id")
	private CIE10 diagnostico;
	
	
	
	public CIE10 getDiagnostico() {
		return diagnostico;
	}
	
	
	public void setDiagnostico(CIE10 diagnostico) {
		this.diagnostico = diagnostico;
	}
	public double getValorEmpresa() {
		return valorEmpresa;
	}
	public void setValorEmpresa(double valorEmpresa) {
		this.valorEmpresa = valorEmpresa;
	}
	
	public double getValorEPS() {
		return valorEPS;
	}
	public void setValorEPS(double valorEPS) {
		this.valorEPS = valorEPS;
	}
	public double getValorARL() {
		return valorARL;
	}
	public void setValorARL(double valorARL) {
		this.valorARL = valorARL;
	}
	public double getValorPensiones() {
		return valorPensiones;
	}
	public void setValorPensiones(double valorPensiones) {
		this.valorPensiones = valorPensiones;
	}
	@Override
	public String toString() {
		return "Ausentismo [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", tipoID=" + tipoID
				+ ", numID=" + numID + ", tipoIncapacidad=" + tipoIncapacidad + ", cargo=" + cargo + ", EPS=" + EPS
				+ ", salario=" + salario + ", salarioDia=" + salarioDia + ", fechaInicial=" + fechaInicial
				+ ", fechaFin=" + fechaFin + ", totalDias=" + totalDias + ", clasificacion=" + clasificacion + "]";
	}
	public Ausentismo() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getTipoID() {
		return tipoID;
	}
	public void setTipoID(String tipoID) {
		this.tipoID = tipoID;
	}
	public String getNumID() {
		return numID;
	}
	public void setNumID(String numID) {
		this.numID = numID;
	}
	public String getTipoIncapacidad() {
		return tipoIncapacidad;
	}
	public void setTipoIncapacidad(String tipoIncapacidad) {
		this.tipoIncapacidad = tipoIncapacidad;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public String getEPS() {
		return EPS;
	}
	public void setEPS(String ePS) {
		EPS = ePS;
	}
	public int getSalario() {
		return salario;
	}
	public void setSalario(int salario) {
		this.salario = salario;
	}
	public double getSalarioDia() {
		return salarioDia;
	}
	public void setSalarioDia(double salarioDia) {
		this.salarioDia = salarioDia;
	}
	public Date getFechaInicial() {
		return fechaInicial;
	}
	public void setFechaInicial(Date fechaInicial) {
		this.fechaInicial = fechaInicial;
	}
	public Date getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	public int getTotalDias() {
		return totalDias;
	}
	public void setTotalDias(int totalDias) {
		this.totalDias = totalDias;
	}
	public String getClasificacion() {
		return clasificacion;
	}
	public void setClasificacion(String clasificacion) {
		this.clasificacion = clasificacion;
	}
	
	
	
}