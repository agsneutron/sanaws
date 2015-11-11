
package com.sanaTF.dao;

import java.util.List;
import com.sanaTF.model.Renovacion;

public interface RenovacionDao {
	public void add(Renovacion renovacion);
	public void edit(Renovacion renovacion);
	public void delete(int idRenovacionAumento);
	public Renovacion getRenovacion(int idRenovacionAumento);
	public List getAllRenovacion();
}
