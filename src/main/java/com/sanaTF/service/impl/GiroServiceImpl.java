package com.sanaTF.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sanaTF.dao.GiroDao;
import com.sanaTF.model.Giro;
import com.sanaTF.service.GiroService;

@Service
public class GiroServiceImpl implements GiroService {
	@Autowired
	private GiroDao giroDao;
	
	@Transactional
	public void add(Giro giro) {
		giroDao.add(giro);

	}

	@Transactional
	public void edit(Giro giro) {
		giroDao.edit(giro);

	}

	@Transactional
	public void delete(int idGiro) {
		giroDao.delete(idGiro);

	}

	@Transactional
	public Giro getGiro(int idGiro) {
		return giroDao.getGiro(idGiro);
	}
	

	@Transactional
	public List getAllGiros() {
		return giroDao.getAllGiros();
	}

}