package com.mvc;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.mvc.beans.User;

public interface UserRepository extends JpaRepository<User, String> {
	
	@Query(value="SELECT u.username FROM User u")
	public List<String> findAllUserNames(); 
	
	@Query(value="SELECT u FROM User u where u.userType=?1")
	public List<User> findAllUsers(String usertype, Pageable pageable);
	
	@Query(value="SELECT u.username FROM User u")
	public List<String> findUserNames(Pageable pageable);
	
	@Query(value="SELECT u FROM User u")
	public List<User> sortUserNames(Sort sort);
	
	/*//In case of DML @Modifying annotation must be used which is not required for DDL
	@Modifying
	@Query("update user set mobile=?1 where username=1?")
	public Integer updateMobile(String username, String mobile);*/
}
