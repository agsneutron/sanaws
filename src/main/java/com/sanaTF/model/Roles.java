package com.sanaTF.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
@Entity(name="roles_v")
public class Roles {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id_rol;
	private String nombre_rol;
	//@OneToOne(mappedBy = "rol")
	//private Usuarios users;
	
	public Roles(){}

	//public Roles(int id_rol, String nombre_rol, Usuarios users) {
	public Roles(int id_rol, String nombre_rol) {
		super();
		this.id_rol = id_rol;
		this.nombre_rol = nombre_rol;
		//this.users = users;
	}

	

	public int getId_rol() {
		return id_rol;
	}

	public void setId_rol(int id_rol) {
		this.id_rol = id_rol;
	}

	public String getRoleName() {
		return nombre_rol;
	}

	public void setRoleName(String nombre_rol) {
		this.nombre_rol = nombre_rol;
	}


}