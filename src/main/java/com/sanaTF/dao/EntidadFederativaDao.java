package com.sanaTF.dao;

import java.util.List;
import com.sanaTF.model.EntidadFederativa;

public interface EntidadFederativaDao {
	public void add(EntidadFederativa entidadfederativa);
	public void edit(EntidadFederativa entidadfederativa);
	public void delete(int idEntidadFederativa);
	public EntidadFederativa getEntidadFederativa(int idEntidadFederativa);
	public List getAllEntidadFederativa();
}
