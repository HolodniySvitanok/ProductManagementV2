package com.holodniysvitanok.dao;

import java.util.List;

import com.holodniysvitanok.entity.User;

public interface UserDAO {

	User getUserByLogin(String login);
	
	boolean saveUser(User user);
	
	User getUserById(long id);
	
	void deleteUser(User user);
	
	List<User> getAllUsers(int start, int maxRows);
	
	List<User> getAllUsers(int count);
}
