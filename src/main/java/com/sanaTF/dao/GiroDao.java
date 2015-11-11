package com.sanaTF.dao;

import java.util.List;
import com.sanaTF.model.Giro;

public interface GiroDao {
	public void add(Giro giro);
	public void edit(Giro giro);
	public void delete(int idGiro);
	public Giro getGiro(int idGiro);
	public List getAllGiros();
}