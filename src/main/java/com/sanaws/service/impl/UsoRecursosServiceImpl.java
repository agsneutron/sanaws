
package com.sanaws.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sanaws.dao.UsoRecursosDao;
import com.sanaws.model.UsoRecursos;
import com.sanaws.service.UsoRecursosService;

@Service
public class UsoRecursosServiceImpl implements UsoRecursosService {
	@Autowired
	private UsoRecursosDao usorecursosDao;
	
	@Transactional
	public void add(UsoRecursos usorecursos) {
		usorecursosDao.add(usorecursos);

	}

	@Transactional
	public void edit(UsoRecursos usorecursos) {
		usorecursosDao.edit(usorecursos);

	}

	@Transactional
	public void delete(int idUsoRecursos) {
		usorecursosDao.delete(idUsoRecursos);

	}

	@Transactional
	public UsoRecursos getUsoRecursos(int idUsoRecursos) {
		return usorecursosDao.getUsoRecursos(idUsoRecursos);
	}
	

	@Transactional
	public List getAllUsoRecursos() {
		return usorecursosDao.getAllUsoRecursos();
	}

}