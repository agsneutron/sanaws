package com.sanaws.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sanaws.dao.PaisesDao;
import com.sanaws.model.Paises;
import com.sanaws.service.PaisesService;

@Service
public class PaisesServiceImpl implements PaisesService {
	@Autowired
	private PaisesDao paisesDao;
	
	@Transactional
	public void add(Paises paises) {
		paisesDao.add(paises);

	}

	@Transactional
	public void edit(Paises paises) {
		paisesDao.edit(paises);

	}

	@Transactional
	public void delete(int idPais) {
		paisesDao.delete(idPais);

	}

	@Transactional
	public Paises getPaises(int idPais) {
		return paisesDao.getPaises(idPais);
	}
	

	@Transactional
	public List getAllPaises() {
		return paisesDao.getAllPaises();
	}

}
