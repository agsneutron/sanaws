package com.sanaws.model;

public class RutaOptima {
	private double latitud;
	private double longitud;
	private String nombreCliente;
	private int orden;
	private int lugarVisitado;
	
	public RutaOptima(double latitud, double longitud, String nombreCliente, int orden, int lugarVisitado) {
		super();
		this.latitud = latitud;
		this.longitud = longitud;
		this.nombreCliente = nombreCliente;
		this.orden = orden;
		this.lugarVisitado = lugarVisitado;
	}

	public double getLatitud() {
		return latitud;
	}

	public void setLatitud(double latitud) {
		this.latitud = latitud;
	}

	public double getLongitud() {
		return longitud;
	}

	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public int getOrden() {
		return orden;
	}

	public void setOrden(int orden) {
		this.orden = orden;
	}

	public int getLugarVisitado() {
		return lugarVisitado;
	}

	public void setLugarVisitado(int lugarVisitado) {
		this.lugarVisitado = lugarVisitado;
	}
	
	
	
}
