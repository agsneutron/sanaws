
package com.sanaTF.dao;

import java.util.List;
import com.sanaTF.model.UsoRecursos;

public interface UsoRecursosDao {
	public void add(UsoRecursos usorecursos);
	public void edit(UsoRecursos usorecursos);
	public void delete(int idUsoRecursos);
	public UsoRecursos getUsoRecursos(int idUsoRecursos);
	public List getAllUsoRecursos();
}