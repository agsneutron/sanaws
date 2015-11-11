package com.sanaTF.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;



@Entity(name="User")
public class User implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int User_Id;
	private String Usuario;
	private String Contrasena;	
	@ManyToMany
	@JoinTable(name="Usuarios_Roles",
			joinColumns=@JoinColumn(name="user_id"),
			inverseJoinColumns=@JoinColumn(name="rol_id"))
	private List<Role> roles;
	
	
	@Enumerated(EnumType.STRING)
	private UserStatus Activo;
	
	public User(){}

	public User(int User_Id, String Usuario, String Contrasena,List<Role> roles,
			UserStatus Activo) {
		super();
		this.User_Id = User_Id;
		this.Usuario = Usuario;
		this.Contrasena = Contrasena;		
		this.roles = roles;
		this.Activo = Activo;
	}

	public int getId() {
		return User_Id;
	}

	public void setId(int User_Id) {
		this.User_Id = User_Id;
	}

	public String getUsername() {
		return Usuario;
	}

	public void setUsername(String Usuario) {
		this.Usuario = Usuario;
	}

	public String getPassword() {
		return Contrasena;
	}

	public void setPassword(String Contrasena) {
		this.Contrasena = Contrasena;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public UserStatus getStatus() {
		return Activo;
	}

	public void setStatus(UserStatus Activo) {
		this.Activo = Activo;
	}

	
	
	
}
