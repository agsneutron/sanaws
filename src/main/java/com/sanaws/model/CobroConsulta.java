package com.sanaws.model;

public class CobroConsulta {
	private String capital;
	private String interes;
    private String moratorios;
    private String subTotal;
    private String iva;
    private String total;
    private String saldo;
    private String cajero;
    private String sucursal;
    private String plaza;
    private String nombreCliente;
    private String idCliente;
    private String creditoId;
    private String montoPago;
    private String fecha;
    private String hora;
    private String fechaproxima;
    
	private String codigoRespuesta;
	private String mensajeRespuesta;
	public CobroConsulta(String capital, String interes, String moratorios, String subTotal, String iva, String total,
			String saldo, String cajero, String sucursal, String plaza, String nombreCliente, String idCliente,
			String creditoId, String montoPago, String fecha, String hora, String fechaproxima, String codigoRespuesta,
			String mensajeRespuesta) {
		super();
		this.capital = capital;
		this.interes = interes;
		this.moratorios = moratorios;
		this.subTotal = subTotal;
		this.iva = iva;
		this.total = total;
		this.saldo = saldo;
		this.cajero = cajero;
		this.sucursal = sucursal;
		this.plaza = plaza;
		this.nombreCliente = nombreCliente;
		this.idCliente = idCliente;
		this.creditoId = creditoId;
		this.montoPago = montoPago;
		this.fecha = fecha;
		this.hora = hora;
		this.fechaproxima = fechaproxima;
		this.codigoRespuesta = codigoRespuesta;
		this.mensajeRespuesta = mensajeRespuesta;
	}
	public String getCapital() {
		return capital;
	}
	public void setCapital(String capital) {
		this.capital = capital;
	}
	public String getInteres() {
		return interes;
	}
	public void setInteres(String interes) {
		this.interes = interes;
	}
	public String getMoratorios() {
		return moratorios;
	}
	public void setMoratorios(String moratorios) {
		this.moratorios = moratorios;
	}
	public String getSubTotal() {
		return subTotal;
	}
	public void setSubTotal(String subTotal) {
		this.subTotal = subTotal;
	}
	public String getIva() {
		return iva;
	}
	public void setIva(String iva) {
		this.iva = iva;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	public String getSaldo() {
		return saldo;
	}
	public void setSaldo(String saldo) {
		this.saldo = saldo;
	}
	public String getCajero() {
		return cajero;
	}
	public void setCajero(String cajero) {
		this.cajero = cajero;
	}
	public String getSucursal() {
		return sucursal;
	}
	public void setSucursal(String sucursal) {
		this.sucursal = sucursal;
	}
	public String getPlaza() {
		return plaza;
	}
	public void setPlaza(String plaza) {
		this.plaza = plaza;
	}
	public String getNombreCliente() {
		return nombreCliente;
	}
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
	public String getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}
	public String getCreditoId() {
		return creditoId;
	}
	public void setCreditoId(String creditoId) {
		this.creditoId = creditoId;
	}
	public String getMontoPago() {
		return montoPago;
	}
	public void setMontoPago(String montoPago) {
		this.montoPago = montoPago;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public String getFechaproxima() {
		return fechaproxima;
	}
	public void setFechaproxima(String fechaproxima) {
		this.fechaproxima = fechaproxima;
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
