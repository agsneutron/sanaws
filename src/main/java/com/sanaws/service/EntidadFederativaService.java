package com.sanaws.service;

import java.util.List;

import com.sanaws.model.EntidadFederativa;

public interface EntidadFederativaService {
	public void add(EntidadFederativa entidadfederativa);
	public void edit(EntidadFederativa entidadfederativa);
	public void delete(int idEntidadFederativa);
	public EntidadFederativa getEntidadFederativa(int idEntidadFederativa);
	public List getAllEntidadFederativa();
}
