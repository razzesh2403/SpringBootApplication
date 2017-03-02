package com.mvc.util;

public class ApplicationConstants {
	
	public static String addUserCommand = "INSERT into USER(username,password,usertype,email,mobile)  VALUES(?,?,?,?,?)";
	public static String deleteUserCommand = "DELETE FROM USER WHERE USERNAME=?";
	public static String getAllUSersCommand = "SELECT * from USER";
	public static String getUserByNameCommand = "SELECT * from USER where username=?";
	public static String getUserByMobileCommand = "SELECT * from USER where mobile=?";
	public static String getUserCommand = "SELECT * from USER where username=?";
	public static String updateUserCommand = "UPDATE USER SET password=?, email=?, mobile=? where username=?";
	public static String getUserNames = "select username from user";
	}
