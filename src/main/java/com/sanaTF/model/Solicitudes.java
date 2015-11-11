package com.sanaTF.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="solicitudes")
public class Solicitudes {
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.AUTO) //for autonumber
	private int idSolicitud;
	@Column
	private String folioSolicitud;
	@Column
	private  String idCliente;
	@Column
	private String negocioCalle;
	@Column
	private String negocioNoExt;
	@Column
	private String negocioNoInt;
	@Column
	private String negocioColonia;
	@Column
	private String negocioMunicipio;
	@Column
	private int negocioIdEntidadFederativa;
	@Column
	private String negocioEntreCalles;
	@Column
	private String negocioTelefono;
	@Column
	private String negocioReferencia;
	@Column
	private int negocioIdGiro;
	@Column
	private String negocioAntiguedad;
	@Column
	private String referenciaNombre1;
	@Column
	private String referenciaParentesco1;
	@Column
	private String referenciaTelefono1;
	@Column
	private String referenciaDomicilio1;
	@Column
	private String referenciaNombre2;
	@Column
	private String referenciaParentesco2;
	@Column
	private String referenciaTelefono2;
	@Column
	private String referenciaDomicilio2;
	@Column
	private String creditoMonto;
	@Column
	private String creditoFrecuenciaPago;
	@Column
	private int creditoPlazo;
	@Column
	private String creditoMedidaPlazo;
	@Column
	private int creditoIdUsoRecursos;
	@Column
	private String creditoOtro;
	@Column
	private int creditoIdRenovacionAumento;
	@Column
	private int creditoIdTipoCredito;
	@Column
	private String comentarios;
	@Column
	private String autorizacionUsoDatos;
	@Column
	private String otroGiro;
	@Column
	private String otroUsoRecursos;
	
				
	public Solicitudes(){}
	public Solicitudes(int idSolicitud, String folioSolicitud, String idCliente,String negocioCalle,String negocioNoExt,
			  String negocioNoInt,String negocioColonia,String negocioMunicipio,int negocioIdEntidadFederativa,
			  String negocioEntreCalles,String negocioTelefono,String negocioReferencia,int negocioIdGiro,String negocioAntiguedad,
			  String referenciaNombre1,String referenciaParentesco1,String referenciaTelefono1,String referenciaDomicilio1,
			  String referenciaNombre2,String referenciaParentesco2,String referenciaTelefono2,String referenciaDomicilio2,
			  String creditoMonto,String creditoFrecuenciaPago,int creditoPlazo,String creditoMedidaPlazo,int creditoIdUsoRecursos,
			  String creditoOtro,int creditoIdRenovacionAumento,int creditoIdTipoCredito,String comentarios,String autorizacionUsoDatos,
			  String otroGiro,String otroUsoRecursos)
		   {
				super();
				this.idSolicitud = idSolicitud;
				this.folioSolicitud = folioSolicitud;   
				this.idCliente = idCliente;
				this.negocioCalle = negocioCalle;
				this.negocioNoExt = negocioNoExt;
				this.negocioNoInt = negocioNoInt;
				this.negocioColonia = negocioColonia;
				this.negocioMunicipio = negocioMunicipio;
				this.negocioIdEntidadFederativa = negocioIdEntidadFederativa;
				this.negocioEntreCalles = negocioEntreCalles;
				this.negocioTelefono = negocioTelefono;
				this.negocioReferencia = negocioReferencia ;
				this.negocioIdGiro = negocioIdGiro ;
				this.negocioAntiguedad = negocioAntiguedad ;
				this.referenciaNombre1 = referenciaNombre1 ;
				this.referenciaParentesco1 = referenciaParentesco1 ;
				this.referenciaTelefono1 = referenciaTelefono1 ;
				this.referenciaDomicilio1 = referenciaDomicilio1 ;
				this.referenciaNombre2 = referenciaNombre2 ;
				this.referenciaParentesco2 = referenciaParentesco2 ;
				this.referenciaTelefono2 = referenciaTelefono2 ;
				this.referenciaDomicilio2 = referenciaDomicilio2 ;
				this.creditoMonto = creditoMonto ;
				this.creditoFrecuenciaPago = creditoFrecuenciaPago ;
				this.creditoPlazo = creditoPlazo ;
				this.creditoMedidaPlazo = creditoMedidaPlazo ;
				this.creditoIdUsoRecursos = creditoIdUsoRecursos ;
				this.creditoOtro = creditoOtro ;
				this.creditoIdRenovacionAumento = creditoIdRenovacionAumento ;
				this.creditoIdTipoCredito = creditoIdTipoCredito ;
				this.comentarios = comentarios ;
				this.autorizacionUsoDatos = autorizacionUsoDatos ;
				this.otroGiro = otroGiro ;
				this.otroUsoRecursos = otroUsoRecursos ;				
		   }
	public int getIdSolicitud() {
		return idSolicitud;
	}
	public void setIdSolicitud(int idSolicitud) {
		this.idSolicitud = idSolicitud;
	}
	public String getFolioSolicitud() {
		return folioSolicitud;
	}
	public void setFolioSolicitud(String folioSolicitud) {
		this.folioSolicitud = folioSolicitud;
	}
	public String getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}
	public String getNegocioCalle() {
		return negocioCalle;
	}
	public void setNegocioCalle(String negocioCalle) {
		this.negocioCalle = negocioCalle;
	}
	public String getNegocioNoExt() {
		return negocioNoExt;
	}
	public void setNegocioNoExt(String negocioNoExt) {
		this.negocioNoExt = negocioNoExt;
	}
	public String getNegocioNoInt() {
		return negocioNoInt;
	}
	public void setNegocioNoInt(String negocioNoInt) {
		this.negocioNoInt = negocioNoInt;
	}
	public String getNegocioColonia() {
		return negocioColonia;
	}
	public void setNegocioColonia(String negocioColonia) {
		this.negocioColonia = negocioColonia;
	}
	public String getNegocioMunicipio() {
		return negocioMunicipio;
	}
	public void setNegocioMunicipio(String negocioMunicipio) {
		this.negocioMunicipio = negocioMunicipio;
	}
	public int getNegocioIdEntidadFederativa() {
		return negocioIdEntidadFederativa;
	}
	public void setNegocioIdEntidadFederativa(int negocioIdEntidadFederativa) {
		this.negocioIdEntidadFederativa = negocioIdEntidadFederativa;
	}
	public String getNegocioEntreCalles() {
		return negocioEntreCalles;
	}
	public void setNegocioEntreCalles(String negocioEntreCalles) {
		this.negocioEntreCalles = negocioEntreCalles;
	}
	public String getNegocioTelefono() {
		return negocioTelefono;
	}
	public void setNegocioTelefono(String negocioTelefono) {
		this.negocioTelefono = negocioTelefono;
	}
	public String getNegocioReferencia() {
		return negocioReferencia;
	}
	public void setNegocioReferencia(String negocioReferencia) {
		this.negocioReferencia = negocioReferencia;
	}
	public int getNegocioIdGiro() {
		return negocioIdGiro;
	}
	public void setNegocioIdGiro(int negocioIdGiro) {
		this.negocioIdGiro = negocioIdGiro;
	}
	public String getNegocioAntiguedad() {
		return negocioAntiguedad;
	}
	public void setNegocioAntiguedad(String negocioAntiguedad) {
		this.negocioAntiguedad = negocioAntiguedad;
	}
	public String getReferenciaNombre1() {
		return referenciaNombre1;
	}
	public void setReferenciaNombre1(String referenciaNombre1) {
		this.referenciaNombre1 = referenciaNombre1;
	}
	public String getReferenciaParentesco1() {
		return referenciaParentesco1;
	}
	public void setReferenciaParentesco1(String referenciaParentesco1) {
		this.referenciaParentesco1 = referenciaParentesco1;
	}
	public String getReferenciaTelefono1() {
		return referenciaTelefono1;
	}
	public void setReferenciaTelefono1(String referenciaTelefono1) {
		this.referenciaTelefono1 = referenciaTelefono1;
	}
	public String getReferenciaDomicilio1() {
		return referenciaDomicilio1;
	}
	public void setReferenciaDomicilio1(String referenciaDomicilio1) {
		this.referenciaDomicilio1 = referenciaDomicilio1;
	}
	public String getReferenciaNombre2() {
		return referenciaNombre2;
	}
	public void setReferenciaNombre2(String referenciaNombre2) {
		this.referenciaNombre2 = referenciaNombre2;
	}
	public String getReferenciaParentesco2() {
		return referenciaParentesco2;
	}
	public void setReferenciaParentesco2(String referenciaParentesco2) {
		this.referenciaParentesco2 = referenciaParentesco2;
	}
	public String getReferenciaTelefono2() {
		return referenciaTelefono2;
	}
	public void setReferenciaTelefono2(String referenciaTelefono2) {
		this.referenciaTelefono2 = referenciaTelefono2;
	}
	public String getReferenciaDomicilio2() {
		return referenciaDomicilio2;
	}
	public void setReferenciaDomicilio2(String referenciaDomicilio2) {
		this.referenciaDomicilio2 = referenciaDomicilio2;
	}
	public String getCreditoMonto() {
		return creditoMonto;
	}
	public void setCreditoMonto(String creditoMonto) {
		this.creditoMonto = creditoMonto;
	}
	public String getCreditoFrecuenciaPago() {
		return creditoFrecuenciaPago;
	}
	public void setCreditoFrecuenciaPago(String creditoFrecuenciaPago) {
		this.creditoFrecuenciaPago = creditoFrecuenciaPago;
	}
	public int getCreditoPlazo() {
		return creditoPlazo;
	}
	public void setCreditoPlazo(int creditoPlazo) {
		this.creditoPlazo = creditoPlazo;
	}
	public String getCreditoMedidaPlazo() {
		return creditoMedidaPlazo;
	}
	public void setCreditoMedidaPlazo(String creditoMedidaPlazo) {
		this.creditoMedidaPlazo = creditoMedidaPlazo;
	}
	public int getCreditoIdUsoRecursos() {
		return creditoIdUsoRecursos;
	}
	public void setCreditoIdUsoRecursos(int creditoIdUsoRecursos) {
		this.creditoIdUsoRecursos = creditoIdUsoRecursos;
	}
	public String getCreditoOtro() {
		return creditoOtro;
	}
	public void setCreditoOtro(String creditoOtro) {
		this.creditoOtro = creditoOtro;
	}
	public int getCreditoIdRenovacionAumento() {
		return creditoIdRenovacionAumento;
	}
	public void setCreditoIdRenovacionAumento(int creditoIdRenovacionAumento) {
		this.creditoIdRenovacionAumento = creditoIdRenovacionAumento;
	}
	public int getCreditoIdTipoCredito() {
		return creditoIdTipoCredito;
	}
	public void setCreditoIdTipoCredito(int creditoIdTipoCredito) {
		this.creditoIdTipoCredito = creditoIdTipoCredito;
	}
	public String getComentarios() {
		return comentarios;
	}
	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}
	public String getAutorizacionUsoDatos() {
		return autorizacionUsoDatos;
	}
	public void setAutorizacionUsoDatos(String autorizacionUsoDatos) {
		this.autorizacionUsoDatos = autorizacionUsoDatos;
	}
	public String getOtroGiro() {
		return otroGiro;
	}
	public void setOtroGiro(String otroGiro) {
		this.otroGiro = otroGiro;
	}
	public String getOtroUsoRecursos() {
		return otroUsoRecursos;
	}
	public void setOtroUsoRecursos(String otroUsoRecursos) {
		this.otroUsoRecursos = otroUsoRecursos;
	}
	
	
} 
