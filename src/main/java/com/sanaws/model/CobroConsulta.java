package com.sanaws.model;

public class CobroConsulta {
	private String saldoTotal;
	private String saldoExigibleDia;
    private String proyeccion;
    private String codigoRespuesta;
    private String mensajeRespuesta;
    
	public CobroConsulta(String saldoTotal, String saldoExigibleDia, String proyeccion, String codigoRespuesta,
			String mensajeRespuesta) {
		super();
		this.saldoTotal = saldoTotal;
		this.saldoExigibleDia = saldoExigibleDia;
		this.proyeccion = proyeccion;
		this.codigoRespuesta = codigoRespuesta;
		this.mensajeRespuesta = mensajeRespuesta;
	}
	
	public String getSaldoTotal() {
		return saldoTotal;
	}
	public void setSaldoTotal(String saldoTotal) {
		this.saldoTotal = saldoTotal;
	}
	public String getSaldoExigibleDia() {
		return saldoExigibleDia;
	}
	public void setSaldoExigibleDia(String saldoExigibleDia) {
		this.saldoExigibleDia = saldoExigibleDia;
	}
	public String getProyeccion() {
		return proyeccion;
	}
	public void setProyeccion(String proyeccion) {
		this.proyeccion = proyeccion;
	}
	public String getCodigoRespuesta() {
		return codigoRespuesta;
	}
	public void setCodigoRespuesta(String codigoRespuesta) {
		this.codigoRespuesta = codigoRespuesta;
	}
	public String getMensajeRespuesta() {
		return mensajeRespuesta;
	}
	public void setMensajeRespuesta(String mensajeRespuesta) {
		this.mensajeRespuesta = mensajeRespuesta;
	}
    
   
    

}
