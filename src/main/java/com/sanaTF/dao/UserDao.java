package com.sanaTF.dao;

import java.util.List;

import com.sanaTF.model.User;

public interface UserDao {
	void addUser(User user);
	void editUser(User user);
	void deleteUser(int User_Id);
	User findUser(int User_Id);
	User findUserByName(String Usuario);
	List<User> getAllUsers();
}
