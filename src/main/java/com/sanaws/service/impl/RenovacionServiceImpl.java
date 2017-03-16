
package com.sanaws.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sanaws.dao.RenovacionDao;
import com.sanaws.model.Renovacion;
import com.sanaws.service.RenovacionService;

@Service
public class RenovacionServiceImpl implements RenovacionService {
	@Autowired
	private RenovacionDao renovacionDao;
	
	@Transactional
	public void add(Renovacion renovacion) {
		renovacionDao.add(renovacion);

	}

	@Transactional
	public void edit(Renovacion renovacion) {
		renovacionDao.edit(renovacion);

	}

	@Transactional
	public void delete(int idRenovacionAumento) {
		renovacionDao.delete(idRenovacionAumento);

	}

	@Transactional
	public Renovacion getRenovacion(int idRenovacionAumento) {
		return renovacionDao.getRenovacion(idRenovacionAumento);
	}
	

	@Transactional
	public List getAllRenovacion() {
		return renovacionDao.getAllRenovacion();
	}

}
