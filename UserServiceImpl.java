package com.mvc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mvc.beans.User;
import com.mvc.dao.UserDao;
import com.mvc.service.UserService;



public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao userDao;
	

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		userDao.addUser(user);
		
	}

	@Override
	public void deleteUser(User user) {
		// TODO Auto-generated method stub
		userDao.deleteUser(user);
	}

	@Override
	public User findUser(User user) {
		// TODO Auto-generated method stub
		return userDao.findUser(user);
	}

	@Override
	public User findByName(String name) {
		// TODO Auto-generated method stub
		return userDao.findByName(name);
		
	}

	@Override
	public User findByMobile(String no) {
		// TODO Auto-generated method stub
		return userDao.findByMobile(no);
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		userDao.updateUser(user);
		
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userDao.getAllUsers();
	}

}
