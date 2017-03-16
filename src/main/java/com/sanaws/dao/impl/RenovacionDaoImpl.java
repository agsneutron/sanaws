
package com.sanaws.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sanaws.dao.RenovacionDao;
import com.sanaws.model.Renovacion;


@Repository
public class RenovacionDaoImpl implements RenovacionDao {
	@Autowired
	private SessionFactory session;

	@Override
	public void add(Renovacion renovacion) {
		session.getCurrentSession().save(renovacion);

	}

	@Override
	public void edit(Renovacion renovacion) {
		session.getCurrentSession().update(renovacion);

	}

	@Override
	public void delete(int idRenovacionAumento) {
		session.getCurrentSession().delete(getRenovacion(idRenovacionAumento));

	}

	@Override
	public Renovacion getRenovacion(int idRenovacionAumento) {
		return (Renovacion)session.getCurrentSession().createQuery("from Renovacion f where f.idRenovacionAumento=:idRenovacionAumento")
				.setParameter("idRenovacionAumento",idRenovacionAumento)
				.uniqueResult();
				
	}


	@Override
	public List getAllRenovacion() {
		return session.getCurrentSession().createQuery("from Renovacion").list();
	}

}

