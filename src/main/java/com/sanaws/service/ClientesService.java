package com.sanaws.service;

import java.util.List;

import com.sanaws.model.Clientes;

public interface ClientesService {
	public void add(Clientes clientes);
	public void edit(Clientes clientes);
	public void delete(int idClientes);
	public Clientes getClientes(int idClientes);
	public List getAllClientes();
}