package com.sanaTF.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sanaTF.dao.SolicitudesDao;
import com.sanaTF.model.Solicitudes;
import com.sanaTF.service.SolicitudesService;

@Service
public class SolicitudesServiceImpl implements SolicitudesService {
	@Autowired
	private SolicitudesDao solicitudesDao;
	
	@Transactional
	public void add(Solicitudes solicitudes) {
		solicitudesDao.add(solicitudes);

	}

	@Transactional
	public void edit(Solicitudes solicitudes) {
		solicitudesDao.edit(solicitudes);

	}

	@Transactional
	public void delete(int idSolicitudes) {
		solicitudesDao.delete(idSolicitudes);

	}

	@Transactional
	public Solicitudes getSolicitudes(int idSolicitudes) {
		return solicitudesDao.getSolicitudes(idSolicitudes);
	}
	

	@Transactional
	public List getAllSolicitudes() {
		return solicitudesDao.getAllSolicitudes();
	}

}