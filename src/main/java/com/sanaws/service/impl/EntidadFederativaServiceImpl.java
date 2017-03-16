package com.sanaws.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sanaws.dao.EntidadFederativaDao;
import com.sanaws.model.EntidadFederativa;
import com.sanaws.service.EntidadFederativaService;

@Service
public class EntidadFederativaServiceImpl implements EntidadFederativaService {
	@Autowired
	private EntidadFederativaDao entidadfederativaDao;
	
	@Transactional
	public void add(EntidadFederativa entidadfederativa) {
		entidadfederativaDao.add(entidadfederativa);

	}

	@Transactional
	public void edit(EntidadFederativa entidadfederativa) {
		entidadfederativaDao.edit(entidadfederativa);

	}

	@Transactional
	public void delete(int idEntidadFederativa) {
		entidadfederativaDao.delete(idEntidadFederativa);

	}

	@Transactional
	public EntidadFederativa getEntidadFederativa(int idEntidadFederativa) {
		return entidadfederativaDao.getEntidadFederativa(idEntidadFederativa);
	}
	

	@Transactional
	public List getAllEntidadFederativa() {
		return entidadfederativaDao.getAllEntidadFederativa();
	}

}
