package com.sanaTF.service;

import java.util.List;
import com.sanaTF.model.UsoRecursos;

public interface UsoRecursosService {
	public void add(UsoRecursos usorecursos);
	public void edit(UsoRecursos usorecursos);
	public void delete(int idUsoRecursos);
	public UsoRecursos getUsoRecursos(int idUsoRecursos);
	public List getAllUsoRecursos();
}
