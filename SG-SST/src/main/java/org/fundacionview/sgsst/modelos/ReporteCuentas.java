package org.fundacionview.sgsst.modelos;

import org.springframework.stereotype.Component;

@Component
public class ReporteCuentas {

	private double EPS;
	public ReporteCuentas() {
		super();
	}
	public double getEPS() {
		return EPS;
	}
	public void setEPS(double ePS) {
		EPS = ePS;
	}
	public double getARL() {
		return ARL;
	}
	public void setARL(double aRL) {
		ARL = aRL;
	}
	public double getPensiones() {
		return Pensiones;
	}
	public void setPensiones(double pensiones) {
		Pensiones = pensiones;
	}
	public double getEmpresa() {
		return Empresa;
	}
	public void setEmpresa(double empresa) {
		Empresa = empresa;
	}
	private double ARL;
	private double Pensiones;
	private double Empresa;
	
	
	
}