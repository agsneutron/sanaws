

package com.sanaws.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sanaws.dao.TipoCreditoDao;
import com.sanaws.model.TipoCredito;


@Repository
public class TipoCreditoDaoImpl implements TipoCreditoDao {
	@Autowired
	private SessionFactory session;

	@Override
	public void add(TipoCredito tipocredito) {
		session.getCurrentSession().save(tipocredito);

	}

	@Override
	public void edit(TipoCredito tipocredito) {
		session.getCurrentSession().update(tipocredito);

	}

	@Override
	public void delete(int idTipoCredito) {
		session.getCurrentSession().delete(getTipoCredito(idTipoCredito));

	}

	@Override
	public TipoCredito getTipoCredito(int idTipoCredito) {
		return (TipoCredito)session.getCurrentSession().createQuery("from TipoCredito f where f.idTipoCredito=:idTipoCredito")
				.setParameter("idTipoCredito",idTipoCredito)
				.uniqueResult();
				
	}


	@Override
	public List getAllTipoCredito() {
		return session.getCurrentSession().createQuery("from TipoCredito").list();
	}

}

