package com.sanaws.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sanaws.dao.GiroDao;
import com.sanaws.model.Giro;
import com.sanaws.service.GiroService;

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