package com.sanaTF.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="tipo_credito")
public class TipoCredito {
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.AUTO) //for autonumber
	private int idTipoCredito;
	@Column
	private String nombre;
	@Column
	private String descripcion;
	
	
				
	public TipoCredito(){}
	public TipoCredito( int idTipoCredito,String nombre,String descripcion)
		   {
				super();
				this.idTipoCredito = idTipoCredito;
				this.nombre = nombre;
				this.descripcion = descripcion;
		   }
	public int getIdTipoCredito() {
		return idTipoCredito;
	}
	public void setIdTipoCredito(int idTipoCredito) {
		this.idTipoCredito = idTipoCredito;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	
}
