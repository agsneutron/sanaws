package com.sanaws.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
@Entity(name="Usuarios_Roles")
public class UsuariosRoles {
	@Id	
	@Column(name="user_id")
	private int user_id;
	@Column(name="rol_id")
	private int rol_id;	
	
	//@OneToOne(mappedBy="rol")    
    //@MapsId
    //private Usuarios usuarios;

	
	
	public UsuariosRoles(){}

	public UsuariosRoles(int user_id, int rol_id) {
		super();
		this.user_id = user_id;
		this.rol_id = rol_id;
		
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getRol_id() {
		return rol_id;
	}

	public void setRol_id(int rol_id) {
		this.rol_id = rol_id;
	}

	
	

}
