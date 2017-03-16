package com.sanaws.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="giro")
public class Giro {
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.AUTO) //for autonumber
	private int idGiro;
	@Column
	private double idActividadBMX;
	@Column
	private int idActividadINEGI;
	@Column
	private String nombre;
	
	
				
	public Giro(){}



	public Giro(int idGiro, double idActividadBMX, int idActividadINEGI, String nombre) {
		super();
		this.idGiro = idGiro;
		this.idActividadBMX = idActividadBMX;
		this.idActividadINEGI = idActividadINEGI;
		this.nombre = nombre;
	}



	public int getIdGiro() {
		return idGiro;
	}



	public void setIdGiro(int idGiro) {
		this.idGiro = idGiro;
	}



	public double getIdActividadBMX() {
		return idActividadBMX;
	}



	public void setIdActividadBMX(double idActividadBMX) {
		this.idActividadBMX = idActividadBMX;
	}



	public int getIdActividadINEGI() {
		return idActividadINEGI;
	}



	public void setIdActividadINEGI(int idActividadINEGI) {
		this.idActividadINEGI = idActividadINEGI;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



			
}
