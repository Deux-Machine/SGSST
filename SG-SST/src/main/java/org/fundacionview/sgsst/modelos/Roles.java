package org.fundacionview.sgsst.modelos;

public enum Roles {

	Admin("ADMINISTRADOR"),
	Auxiliar("AUXILIAR"),
	Consulta("CONSULTA");
	
	private String roleName;

	private Roles(String roleName) {
		this.roleName = roleName;
	}
	
	public String getRoleName() {
		return roleName;
	}
	
	
}