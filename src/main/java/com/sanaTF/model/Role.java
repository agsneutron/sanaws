package com.sanaTF.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
@Entity(name="Roles")
public class Role {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id_rol;
	private String nombre_rol;
	@ManyToMany(mappedBy = "roles")
	private List<User> users;
	
	public Role(){}

	public Role(int id_rol, String nombre_rol, List<User> users) {
		super();
		this.id_rol = id_rol;
		this.nombre_rol = nombre_rol;
		this.users = users;
	}

	public int getId() {
		return id_rol;
	}

	public void setId(int id_rol) {
		this.id_rol = id_rol;
	}

	public String getRoleName() {
		return nombre_rol;
	}

	public void setRoleName(String nombre_rol) {
		this.nombre_rol = nombre_rol;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
}
