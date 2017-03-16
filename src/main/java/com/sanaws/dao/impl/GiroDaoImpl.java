package com.sanaws.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sanaws.dao.GiroDao;
import com.sanaws.model.Giro;


@Repository
public class GiroDaoImpl implements GiroDao {
	@Autowired
	private SessionFactory session;

	@Override
	public void add(Giro giro) {
		session.getCurrentSession().save(giro);

	}

	@Override
	public void edit(Giro giro) {
		session.getCurrentSession().update(giro);

	}

	@Override
	public void delete(int idGiro) {
		session.getCurrentSession().delete(getGiro(idGiro));

	}

	@Override
	public Giro getGiro(int idGiro) {
		return (Giro)session.getCurrentSession().createQuery("from Giro f where f.idGiro=:idGiro")
				.setParameter("idGiro",idGiro)
				.uniqueResult();
				
	}


	@Override
	public List getAllGiros() {
		return session.getCurrentSession().createQuery("from Giro").list();
	}

}

