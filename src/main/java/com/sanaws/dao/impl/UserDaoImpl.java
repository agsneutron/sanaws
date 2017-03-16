package com.sanaws.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sanaws.dao.UserDao;
import com.sanaws.model.User;


@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory session;
	
	@Override
	public void addUser(User user) {
		session.getCurrentSession().save(user);
	}

	@Override
	public void editUser(User user) {
		session.getCurrentSession().update(user);
	}

	@Override
	public void deleteUser(int User_Id) {
		session.getCurrentSession().delete(findUser(User_Id));

	}

	@Override
	public User findUser(int User_Id) {
		return (User) session.getCurrentSession().get(User.class, User_Id);
	}


	@Override
	public User findUserByName(String Usuario) {
		Criteria criteria = session.getCurrentSession().createCriteria(User.class);
		criteria.add(Restrictions.eq("Usuario", Usuario));		
		return (User) criteria.uniqueResult();
	}

	@Override
	public List<User> getAllUsers() {
		return session.getCurrentSession().createQuery("from User").list();
	}

}
