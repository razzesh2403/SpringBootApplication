package com.mvc.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.mvc.beans.User;
import com.mvc.dao.UserDao;
import com.mvc.util.ApplicationConstants;

public class UserDaoImpl implements UserDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		jdbcTemplate.update(ApplicationConstants.addUserCommand,
				new Object[] { user.getUsername(), user.getPassword(), "user", user.getEmail(), user.getMobile() });

	}

	@Override
	public void deleteUser(User user) {
		// TODO Auto-generated method stub
		jdbcTemplate.update(ApplicationConstants.deleteUserCommand, new Object[] { user.getUsername() });
	}

	@Override
	public User findUser(User user) {

		return (User) jdbcTemplate.queryForObject(ApplicationConstants.getUserCommand,
				new Object[] { user.getUsername() }, new CustomUserRowMapper());

	}

	@Override
	public User findByName(String name) {

		return (User) jdbcTemplate.queryForObject(ApplicationConstants.getUserByNameCommand, new Object[] { name },
				new CustomUserRowMapper());

	}

	@Override
	public User findByMobile(String mobile) {
		System.out.println("find user");
		return (User) jdbcTemplate.queryForObject(ApplicationConstants.getUserByMobileCommand, new Object[] { mobile },
				new CustomUserRowMapper());
	}

	@Override
	public void updateUser(User user) {

		jdbcTemplate.update(ApplicationConstants.updateUserCommand, new Object[] {user.getPassword(),user.getEmail(), user.getMobile(), user.getUsername() });

	}

	@Override
	public List<User> getAllUsers() {

		List<User> usersList = new ArrayList<>();
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(ApplicationConstants.getAllUSersCommand);
		for (Map row : rows) {
			User userResult = new User();
			userResult.setUsername((row.get("username") != null) ? row.get("username").toString() : "");
			userResult.setPassword((row.get("password") != null) ? row.get("password").toString() : "");
			userResult.setEmail((row.get("email") != null) ? row.get("email").toString() : "");
			userResult.setMobile((row.get("mobile") != null) ? row.get("mobile").toString() : "");
			usersList.add(userResult);
		}

		return usersList;
	}
	
	@Override
	public List<String> getUserNames(){
		List<String> userNames = jdbcTemplate.queryForList(ApplicationConstants.getUserNames,String.class);
		return userNames;
	}

	public class CustomUserRowMapper implements RowMapper<User> {

		@Override
		public User mapRow(ResultSet rs, int i) throws SQLException {
			User user = new User();
			user.setUsername((rs.getString("username") != null) ? rs.getString("username").toString() : "");
			user.setPassword((rs.getString("password") != null) ? rs.getString("password").toString() : "");
			user.setEmail((rs.getString("email") != null) ? rs.getString("email").toString() : "");
			user.setMobile((rs.getString("mobile") != null) ? rs.getString("mobile").toString() : "");
			return user;
		}

	}

}
