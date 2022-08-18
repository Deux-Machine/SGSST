package org.fundacionview.sgsst.modelos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tbl_empleado")
public class Empleado extends ModeloBase{


	
	@Size(min = 2,message = "El nombre es requerido")
	private String nombre;	
	private String apellidos;
	private String tipoID;
	
	@Column(unique = true)
	private String numID;
	private int salario;
	private String cargo;
	private String areaTrabajo;
	private int edad;
	private String EPS;
	private String AFP;
	private String ARL;

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
	public int getSalario() {
		return salario;
	}
	public void setSalario(int salario) {
		this.salario = salario;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public String getAreaTrabajo() {
		return areaTrabajo;
	}
	public void setAreaTrabajo(String areaTrabajo) {
		this.areaTrabajo = areaTrabajo;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getEPS() {
		return EPS;
	}
	public void setEPS(String ePS) {
		EPS = ePS;
	}
	public String getAFP() {
		return AFP;
	}
	public void setAFP(String aFP) {
		AFP = aFP;
	}
	public String getARL() {
		return ARL;
	}
	public void setARL(String aRL) {
		ARL = aRL;
	}
	
	
	public Empleado() {
		super();
	}
	@Override
	public String toString() {
		return "Empleado [id=, nombre=" + nombre + ", apellidos=" + apellidos + ", tipoID=" + tipoID
				+ ", numID=" + numID + ", salario=" + salario + ", cargo=" + cargo + ", areaTrabajo=" + areaTrabajo
				+ ", edad=" + edad + ", EPS=" + EPS + ", AFP=" + AFP + ", ARL=" + ARL + "]";
	}
	
	
	
	
	
	
}