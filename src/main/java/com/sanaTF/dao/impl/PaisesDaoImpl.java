

package com.sanaTF.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sanaTF.dao.PaisesDao;
import com.sanaTF.model.Paises;


@Repository
public class PaisesDaoImpl implements PaisesDao {
	@Autowired
	private SessionFactory session;

	@Override
	public void add(Paises paises) {
		session.getCurrentSession().save(paises);

	}

	@Override
	public void edit(Paises paises) {
		session.getCurrentSession().update(paises);

	}

	@Override
	public void delete(int idPais) {
		session.getCurrentSession().delete(getPaises(idPais));

	}

	@Override
	public Paises getPaises(int idPais) {
		return (Paises)session.getCurrentSession().createQuery("from Paises f where f.idPais=:idPais")
				.setParameter("idPais",idPais)
				.uniqueResult();
				
	}


	@Override
	public List getAllPaises() {
		return session.getCurrentSession().createQuery("from Paises").list();
	}

}

