package com.sanaTF.service;

import java.util.List;
import com.sanaTF.model.Clientes;

public interface ClientesService {
	public void add(Clientes clientes);
	public void edit(Clientes clientes);
	public void delete(int idClientes);
	public Clientes getClientes(int idClientes);
	public List getAllClientes();
}