package com.sanaws.service;

import java.util.List;

import com.sanaws.model.Paises;

public interface PaisesService {
	public void add(Paises paises);
	public void edit(Paises paises);
	public void delete(int isPais);
	public Paises getPaises(int idPais);
	public List getAllPaises();
}
