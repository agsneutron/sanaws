package com.sanaws.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity(name="frecencia_pago")
public class FrecuenciaPago {
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.AUTO) //for autonumber
	private int idFrecuenciaPago;	
	@Column
	private String descripcion;
	
	public FrecuenciaPago() {}

	public FrecuenciaPago(int idFrecuenciaPago, String descripcion) {
		super();
		this.idFrecuenciaPago = idFrecuenciaPago;
		this.descripcion = descripcion;
	}

	public int getIdFrecuenciaPago() {
		return idFrecuenciaPago;
	}

	public void setIdFrecuenciaPago(int idFrecuenciaPago) {
		this.idFrecuenciaPago = idFrecuenciaPago;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	
	
}


