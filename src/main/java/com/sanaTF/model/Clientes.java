package com.sanaTF.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="clientes")
public class Clientes {
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.AUTO) //for autonumber
	private int idCliente;
	@Column
	private String nombre;
	@Column
	private String apellidoPaterno;
	@Column
	private String apellidoMaterno;
	@Column
	private String sexo;
	@Column
	private String fechaNacimiento;
	@Column
	private String nacionalidad;
	@Column
	private int edad;
	@Column
	private int paisNacimiento;
	@Column
	private int entidadFederativaNacimiento;
	@Column
	private String curp;
	@Column
	private String rfc;
	@Column
	private String telefonolParticular;
	@Column
	private String telefonoCelular;
	@Column
	private String mail;
	@Column
	private String calle;
	@Column
	private String numeroExterior;
	@Column
	private String numeroInterior;
	@Column
	private String colonia;
	@Column
	private String cp;
	@Column
	private String delegacionMunicipio;
	@Column
	private int entidadFederativaDomicilio;
	
				
	public Clientes(){}
	public Clientes( int idCliente,String nombre,String apellidoPaterno,String apellidoMaterno,String sexo,String fechaNacimiento,
			String nacionalidad,int edad,int paisNacimiento,int entidadFederativaNacimiento,String curp,String rfc,
			String telefonolParticular,String telefonoCelular,String mail,String calle,String numeroExterior,
			String numeroInterior,String colonia,String cp,String delegacionMunicipio,int entidadFederativaDomicilio)
		   {
				super();
				 this.idCliente = idCliente;
						 this.nombre = nombre;
						 this.apellidoPaterno = apellidoPaterno;
						 this.apellidoMaterno = apellidoMaterno;
						 this.sexo = sexo;
						 this.fechaNacimiento = fechaNacimiento;
						 this.nacionalidad = nacionalidad;
						 this.edad = edad;
						 this.paisNacimiento = paisNacimiento;
						 this.entidadFederativaNacimiento = entidadFederativaNacimiento;
						 this.curp = curp;
						 this.rfc = rfc;
						 this.telefonolParticular = telefonolParticular;
						 this.telefonoCelular = telefonoCelular;
						 this.mail = mail;
						 this.calle = calle;
						 this.numeroExterior = numeroExterior;
						 this.numeroInterior = numeroInterior;
						 this.colonia = colonia;
						 this.cp = cp;
						 this.delegacionMunicipio = delegacionMunicipio;
						 this.entidadFederativaDomicilio = entidadFederativaDomicilio;
		   }
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidoPaterno() {
		return apellidoPaterno;
	}
	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}
	public String getApellidoMaterno() {
		return apellidoMaterno;
	}
	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getNacionalidad() {
		return nacionalidad;
	}
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public int getPaisNacimiento() {
		return paisNacimiento;
	}
	public void setPaisNacimiento(int paisNacimiento) {
		this.paisNacimiento = paisNacimiento;
	}
	public int getEntidadFederativaNacimiento() {
		return entidadFederativaNacimiento;
	}
	public void setEntidadFederativaNacimiento(int entidadFederativaNacimiento) {
		this.entidadFederativaNacimiento = entidadFederativaNacimiento;
	}
	public String getCurp() {
		return curp;
	}
	public void setCurp(String curp) {
		this.curp = curp;
	}
	public String getRfc() {
		return rfc;
	}
	public void setRfc(String rfc) {
		this.rfc = rfc;
	}
	public String getTelefonolParticular() {
		return telefonolParticular;
	}
	public void setTelefonolParticular(String telefonolParticular) {
		this.telefonolParticular = telefonolParticular;
	}
	public String getTelefonoCelular() {
		return telefonoCelular;
	}
	public void setTelefonoCelular(String telefonoCelular) {
		this.telefonoCelular = telefonoCelular;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public String getNumeroExterior() {
		return numeroExterior;
	}
	public void setNumeroExterior(String numeroExterior) {
		this.numeroExterior = numeroExterior;
	}
	public String getNumeroInterior() {
		return numeroInterior;
	}
	public void setNumeroInterior(String numeroInterior) {
		this.numeroInterior = numeroInterior;
	}
	public String getColonia() {
		return colonia;
	}
	public void setColonia(String colonia) {
		this.colonia = colonia;
	}
	public String getCp() {
		return cp;
	}
	public void setCp(String cp) {
		this.cp = cp;
	}
	public String getDelegacionMunicipio() {
		return delegacionMunicipio;
	}
	public void setDelegacionMunicipio(String delegacionMunicipio) {
		this.delegacionMunicipio = delegacionMunicipio;
	}
	public int getEntidadFederativaDomicilio() {
		return entidadFederativaDomicilio;
	}
	public void setEntidadFederativaDomicilio(int entidadFederativaDomicilio) {
		this.entidadFederativaDomicilio = entidadFederativaDomicilio;
	}
	
	
	
	   
}
