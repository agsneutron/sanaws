

package com.sanaws.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="uso_recursos")
public class UsoRecursos {
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.AUTO) //for autonumber
	private int idUsoRecursos;
	@Column
	private String nombre;
	
	
				
	public UsoRecursos(){}
	public UsoRecursos( int idUsoRecursos,String nombre)
		   {
				super();
				this.idUsoRecursos = idUsoRecursos;
				this.nombre = nombre;				
		   }
	public int getIdUsoRecursos() {
		return idUsoRecursos;
	}
	public void setIdUsoRecursos(int idUsoRecursos) {
		this.idUsoRecursos = idUsoRecursos;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
	
}
