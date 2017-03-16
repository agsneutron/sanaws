package com.sanaws.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
@Entity(name="entidad_federativa")
public class EntidadFederativa {
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.AUTO) //for autonumber
	private int idEntidadFederativa;
	@Column
	private String nombreEntidadFederativa;
	@Column
	private int idPais;
	
				
	public EntidadFederativa(){}
	public EntidadFederativa( int idEntidadFederativa,String nombreEntidadFederativa, int idPais)
		   {
				super();
				this.idEntidadFederativa = idEntidadFederativa;
				this.nombreEntidadFederativa = nombreEntidadFederativa;
				this.idPais = idPais;				
		   }
	public int getIdEntidadFederativa() {
		return idEntidadFederativa;
	}
	public void setIdEntidadFederativa(int idEntidadFederativa) {
		this.idEntidadFederativa = idEntidadFederativa;
	}
	public String getNombreEntidadFederativa() {
		return nombreEntidadFederativa;
	}
	public void setNombreEntidadFederativa(String nombreEntidadFederativa) {
		this.nombreEntidadFederativa = nombreEntidadFederativa;
	}
	public int getIdPais() {
		return idPais;
	}
	public void setIdPais(int idPais) {
		this.idPais = idPais;
	}
	
	
	
}