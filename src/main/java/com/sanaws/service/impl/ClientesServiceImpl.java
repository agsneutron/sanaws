package com.sanaws.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sanaws.dao.ClientesDao;
import com.sanaws.model.Clientes;
import com.sanaws.service.ClientesService;

@Service
public class ClientesServiceImpl implements ClientesService {
	@Autowired
	private ClientesDao clientesDao;
	
	@Transactional
	public void add(Clientes clientes) {
		clientesDao.add(clientes);

	}

	@Transactional
	public void edit(Clientes clientes) {
		clientesDao.edit(clientes);

	}

	@Transactional
	public void delete(int idClientes) {
		clientesDao.delete(idClientes);

	}

	@Transactional
	public Clientes getClientes(int idClientes) {
		return clientesDao.getClientes(idClientes);
	}
	

	@Transactional
	public List getAllClientes() {
		return clientesDao.getAllClientes();
	}

}