package org.fundacionview.sgsst.modelos;

import java.util.Date;


import javax.persistence.*;

@Entity
@Table(name = "tbl_usuarios")
public class Usuario extends ModeloBase {

	
	private String username;
	private String password;
	private Integer enabled;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="id_empleado",referencedColumnName = "id")
	private Empleado empUnoaUno;
	
	@Enumerated(value=EnumType.STRING)
	private Roles roles;
	
	
	private Date createDate;
	
	private Date lastInDate;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Empleado getEmpUnoaUno() {
		return empUnoaUno;
	}

	public void setEmpUnoaUno(Empleado empUnoaUno) {
		this.empUnoaUno = empUnoaUno;
	}

	public Roles getRoles() {
		return roles;
	}

	public void setRoles(Roles roles) {
		this.roles = roles;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getLastInDate() {
		return lastInDate;
	}

	public void setLastInDate(Date lastInDate) {
		this.lastInDate = lastInDate;
	}

	public Integer getEnable() {
		return enabled;
	}

	public void setEnable(Integer enable) {
		this.enabled = enable;
	}
	
	
	
}