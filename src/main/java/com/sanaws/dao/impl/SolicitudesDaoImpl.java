package com.sanaws.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sanaws.dao.SolicitudesDao;
import com.sanaws.model.Solicitudes;


@Repository
public class SolicitudesDaoImpl implements SolicitudesDao {
	@Autowired
	private SessionFactory session;

	@Override
	public void add(Solicitudes solicitudes) {
		session.getCurrentSession().save(solicitudes);

	}

	@Override
	public void edit(Solicitudes solicitudes) {
		session.getCurrentSession().update(solicitudes);

	}

	@Override
	public void delete(int idSolicitudes) {
		session.getCurrentSession().delete(getSolicitudes(idSolicitudes));

	}

	@Override
	public Solicitudes getSolicitudes(int idSolicitudes) {
		return (Solicitudes)session.getCurrentSession().createQuery("from Solicitudes f where f.idSolicitudes=:idSolicitudes")
				.setParameter("idSolicitudes",idSolicitudes)
				.uniqueResult();
				
	}


	@Override
	public List getAllSolicitudes() {
		return session.getCurrentSession().createQuery("from Solicitudes").list();
	}

}

