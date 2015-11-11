package com.sanaTF.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sanaTF.dao.PaisesDao;
import com.sanaTF.model.Paises;
import com.sanaTF.service.PaisesService;

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
