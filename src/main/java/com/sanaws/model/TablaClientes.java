package com.sanaws.model;

public class TablaClientes {
	private String grupo;
	private int idCliente;
	private String cliente;    
    private String direccion;    
    private int idSolicitud;
    private String integrante;
    private int estatus;
    
	

	public TablaClientes(String grupo, int idCliente, String cliente, String direccion, int idSolicitud,
			String integrante, int estatus) {
		super();
		this.grupo = grupo;
		this.idCliente = idCliente;
		this.cliente = cliente;
		this.direccion = direccion;
		this.idSolicitud = idSolicitud;
		this.integrante = integrante;
		this.estatus = estatus;
	}

	
	public String getIntegrante() {
		return integrante;
	}


	public void setIntegrante(String integrante) {
		this.integrante = integrante;
	}


	public int getEstatus() {
		return estatus;
	}


	public void setEstatus(int estatus) {
		this.estatus = estatus;
	}


	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getIdSolicitud() {
		return idSolicitud;
	}

	public void setIdSolicitud(int idSolicitud) {
		this.idSolicitud = idSolicitud;
	}

    
    
}
