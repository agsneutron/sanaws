package com.sanaws.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.MapsId;
import javax.persistence.CascadeType;



@Entity(name="usuarios_v")
public class Usuarios implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int User_Id;
	private String Usuario;
	private String Contrasena;
	private String ReContrasena;
	
	private String nombre;	
	private String direccion;
	private String telefono;	
	private String email;
	
    //@OneToOne(cascade=CascadeType.ALL)
	//@JoinTable(name="Usuarios_Roles",
	//joinColumns=@JoinColumn(name="user_id",referencedColumnName = "User_id"),
	//inverseJoinColumns=@JoinColumn(name="rol_id",referencedColumnName = "rol_id"))	 
	
    //@OneToOne(mappedBy = "usuarios",
    //cascade = CascadeType.ALL, orphanRemoval = true)
		
	//@OneToOne(cascade=CascadeType.ALL)
	//@JoinTable(name="Usuarios_Roles",
	//joinColumns=@JoinColumn(name="user_id"),
	//inverseJoinColumns=@JoinColumn(name="user_id"))
	
	//@OneToOne(cascade={CascadeType.ALL})
	//@JoinTable(name="UsuariosRoles")
	//@MapsId
	//private UsuariosRoles rol;
	
	@OneToOne(cascade=CascadeType.PERSIST)
	@JoinTable(name="Usuarios_Roles",
			joinColumns=@JoinColumn(name="user_id"),
			inverseJoinColumns=@JoinColumn(name="rol_id"))
	private Roles rol;
		
	
	@Enumerated(EnumType.STRING)
	private UsuariosStatus Activo;
	
	public Usuarios(){}

	public Usuarios(int User_Id, String Usuario, String Contrasena, String ReContrasena, String nombre, 
			String direccion, String telefono,String email, Roles rol,
			UsuariosStatus Activo) {
		super();
		this.User_Id = User_Id;
		this.Usuario = Usuario;
		this.Contrasena = Contrasena;
		this.ReContrasena = ReContrasena;
		this.nombre = nombre;		
		this.direccion = direccion;
		this.telefono = telefono;		
		this.email = email;
		this.rol = rol;
		this.Activo = Activo;
	}

	public int getUser_Id() {
		return User_Id;
	}

	public void setUser_Id(int user_Id) {
		this.User_Id = user_Id;
	}

	public String getUsuario() {
		return Usuario;
	}

	public void setUsuario(String usuario) {
		this.Usuario = usuario;
	}

	public String getContrasena() {
		return Contrasena;
	}

	public void setContrasena(String contrasena) {
		this.Contrasena = contrasena;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	

	public String getReContrasena() {
		return ReContrasena;
	}

	public void setReContrasena(String reContrasena) {
		this.ReContrasena = reContrasena;
	}

	public Roles getRol() {
		return rol;
	}

	public void setRol(Roles rol) {
		this.rol = rol;
	}

	public UsuariosStatus getActivo() {
		return Activo;
	}

	public void setActivo(UsuariosStatus activo) {
		this.Activo = activo;
	}

		
}
