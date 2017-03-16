
package com.sanaws.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sanaws.dao.TipoCreditoDao;
import com.sanaws.model.TipoCredito;
import com.sanaws.service.TipoCreditoService;

@Service
public class TipoCreditoServiceImpl implements TipoCreditoService {
	@Autowired
	private TipoCreditoDao tipocreditoDao;
	
	@Transactional
	public void add(TipoCredito tipocredito) {
		tipocreditoDao.add(tipocredito);

	}

	@Transactional
	public void edit(TipoCredito tipocredito) {
		tipocreditoDao.edit(tipocredito);

	}

	@Transactional
	public void delete(int idTipoCredito) {
		tipocreditoDao.delete(idTipoCredito);

	}

	@Transactional
	public TipoCredito getTipoCredito(int idTipoCredito) {
		return tipocreditoDao.getTipoCredito(idTipoCredito);
	}
	

	@Transactional
	public List getAllTipoCredito() {
		return tipocreditoDao.getAllTipoCredito();
	}

}