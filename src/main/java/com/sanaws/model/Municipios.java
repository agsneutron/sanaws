package com.sanaws.model;

public class Municipios {
	private int id;
	private int estado_id;
	private int MunicipioID;
	private String  nombre;
	private int  localidad;
	public Municipios(int id, int estado_id, int municipioID, String nombre, int localidad) {
		super();
		this.id = id;
		this.estado_id = estado_id;
		MunicipioID = municipioID;
		this.nombre = nombre;
		this.localidad = localidad;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getEstado_id() {
		return estado_id;
	}
	public void setEstado_id(int estado_id) {
		this.estado_id = estado_id;
	}
	public int getMunicipioID() {
		return MunicipioID;
	}
	public void setMunicipioID(int municipioID) {
		MunicipioID = municipioID;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getLocalidad() {
		return localidad;
	}
	public void setLocalidad(int localidad) {
		this.localidad = localidad;
	}
	

}
