package org.fundacionview.sgsst.modelos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "diagnosticos_cie10")
public class CIE10 {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String codigo;
	
	private String diagnostico;
	
	private String grupo_dx;
	
	private String seg_osteomuscular;
	
	private String origen;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDiagnostico() {
		return diagnostico;
	}

	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}

	public String getGrupo_dx() {
		return grupo_dx;
	}

	public void setGrupo_dx(String grupo_dx) {
		this.grupo_dx = grupo_dx;
	}

	public String getSeg_osteomuscular() {
		return seg_osteomuscular;
	}

	public void setSeg_osteomuscular(String seg_osteomuscular) {
		this.seg_osteomuscular = seg_osteomuscular;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public CIE10() {
		super();
	}

	@Override
	public String toString() {
		return "CIE10 [id=" + id + ", codigo=" + codigo + ", diagnostico=" + diagnostico + ", grupo_dx=" + grupo_dx
				+ ", seg_osteomuscular=" + seg_osteomuscular + ", origen=" + origen + "]";
	}

}
