package com.sanaws.service;

import java.util.List;

import com.sanaws.model.Renovacion;

public interface RenovacionService {
	public void add(Renovacion renovacion);
	public void edit(Renovacion renovacion);
	public void delete(int idRenovacionAumento);
	public Renovacion getRenovacion(int idRenovacionAumento);
	public List getAllRenovacion();
}

