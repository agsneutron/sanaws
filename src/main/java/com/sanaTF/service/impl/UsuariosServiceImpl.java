package com.sanaTF.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sanaTF.dao.UsuariosDao;
import com.sanaTF.model.Usuarios;
import com.sanaTF.service.UsuariosService;

@Service
public class UsuariosServiceImpl implements UsuariosService {
	@Autowired
	private UsuariosDao usuariosDao;
	
	@Transactional
	public void add(Usuarios usuario) {
		usuariosDao.add(usuario);

	}

	@Transactional
	public void edit(Usuarios usuario) {
		usuariosDao.edit(usuario);

	}

	@Transactional
	public void delete(int idUsuario) {
		usuariosDao.delete(idUsuario);

	}

	@Transactional
	public Usuarios find(int idUsuario) {
		return usuariosDao.find(idUsuario);
	}

	@Transactional
	public Usuarios findByName(String idUsuario) {
		return usuariosDao.findByName(idUsuario);
	}
	

	@Transactional
	public List getAllUsuarios() {
		return usuariosDao.getAllUsuarios();
	}

}
