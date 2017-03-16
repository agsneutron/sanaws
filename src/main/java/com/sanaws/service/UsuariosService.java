package com.sanaws.service;

import java.util.List;

import com.sanaws.model.Usuarios;

public interface UsuariosService {
	void add(Usuarios user);
	void edit(Usuarios user);
	void delete(int User_Id);
	Usuarios find(int User_Id);
	Usuarios findByName(String Usuario);
	List<Usuarios> getAllUsuarios();
}