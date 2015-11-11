package com.sanaTF.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="renovacion_aumento")
public class Renovacion {
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.AUTO) //for autonumber
	private int idRenovacionAumento;
	@Column
	private String nombre;
	
	
				
	public Renovacion(){}
	public Renovacion( int idRenovacionAumento,String nombre)
		   {
				super();
				this.idRenovacionAumento = idRenovacionAumento;
				this.nombre = nombre;				
		   }
	
	public int getIdRenovacionAumento() {
		return idRenovacionAumento;
	}
	public void setIdRenovacionAumento(int idRenovacionAumento) {
		this.idRenovacionAumento = idRenovacionAumento;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
	
}
