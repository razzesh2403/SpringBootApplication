package com.mvc.service;

import java.util.List;

import com.mvc.beans.User;



public interface UserService {
	

	public void addUser(User user);
	public void deleteUser(User user);
	public User findUser(User user);
	public User findByName(String name);
	public User findByMobile(String no);
	public void updateUser(User user);
	public List<User> getAllUsers();

}
