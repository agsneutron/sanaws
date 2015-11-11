package com.sanaTF.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.sanaTF.dao.UsuariosDao;
import com.sanaTF.model.Usuarios;


@Repository
public class UsuariosDaoImpl implements UsuariosDao {

	@Autowired
	private SessionFactory session;
	
	@Override
	public void add(Usuarios user) {
		session.getCurrentSession().save(user);
	}

	@Override
	public void edit(Usuarios user) {
		session.getCurrentSession().update(user);
	}

	@Override
	public void delete(int User_Id) {
		session.getCurrentSession().delete(find(User_Id));

	}

	@Override
	public Usuarios find(int User_Id) {
		return (Usuarios) session.getCurrentSession().get(Usuarios.class, User_Id);
	}


	@Override
	public Usuarios findByName(String Usuario) {
		Criteria criteria = session.getCurrentSession().createCriteria(Usuarios.class);
		criteria.add(Restrictions.eq("Usuario", Usuario));		
		return (Usuarios) criteria.uniqueResult();
	}

	@Override
	public List getAllUsuarios() {
		return  session.getCurrentSession().createQuery("from usuarios_v").list();
	}

}
