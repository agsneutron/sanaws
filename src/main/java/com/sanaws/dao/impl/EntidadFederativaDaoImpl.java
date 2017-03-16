package com.sanaws.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sanaws.dao.EntidadFederativaDao;
import com.sanaws.model.EntidadFederativa;


@Repository
public class EntidadFederativaDaoImpl implements EntidadFederativaDao {
	@Autowired
	private SessionFactory session;

	@Override
	public void add(EntidadFederativa entidadfederativa) {
		session.getCurrentSession().save(entidadfederativa);

	}

	@Override
	public void edit(EntidadFederativa entidadfederativa) {
		session.getCurrentSession().update(entidadfederativa);

	}

	@Override
	public void delete(int idEntidadFederativa) {
		session.getCurrentSession().delete(getEntidadFederativa(idEntidadFederativa));

	}

	@Override
	public EntidadFederativa getEntidadFederativa(int idEntidadFederativa) {
		return (EntidadFederativa)session.getCurrentSession().createQuery("from EntidadFederativa f where f.idEntidadFederativa=:idEntidadFederativa")
				.setParameter("idEntidadFederativa",idEntidadFederativa)
				.uniqueResult();
				
	}


	@Override
	public List getAllEntidadFederativa() {
		return session.getCurrentSession().createQuery("from EntidadFederativa").list();
	}

}
