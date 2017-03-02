package com.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mvc.UserRepository;
import com.mvc.beans.User;
import com.mvc.dao.UserDao;

@Controller
@RequestMapping("/user")
public class UserController {
	
	//@Autowired
	//private UserService userService;
	
	//@Autowired
	private UserDao userDao;
	
	@Autowired
	private UserRepository userRepository;
	
	
	public UserRepository getUserRepository() {
		return userRepository;
	}

	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@RequestMapping(value = "/retrieveUsers", method = RequestMethod.GET)
	public String retrieveusers(Model model){
		//List<User> users = userDao.getAllUsers();
		List<User> users = userRepository.findAll();
		model.addAttribute("users", users);
		return "retrieveUsers";
	}
	
	@RequestMapping(value = "/sortUsers", method = RequestMethod.GET)
	public String sortusers(Model model){
		//List<User> users = userDao.getAllUsers();
		List<User> users = userRepository.sortUserNames(new Sort(Sort.Direction.DESC, "mobile"));
		model.addAttribute("users", users);
		return "sortUsers";
	}
	
	@RequestMapping(value = "/retrieveUsersBasedOnRole", method = RequestMethod.GET)
	public String retrieveusersroles(Model model){
		//List<User> users = userDao.getAllUsers();
		List<User> users = userRepository.findAllUsers("user",new PageRequest(0,2));
		model.addAttribute("users", users);
		return "retrieveUsersBasedOnRole";
	}
	
	@RequestMapping(value = "/addUser", method = RequestMethod.GET)
	public String adduser(Model model){
		
		model.addAttribute("user", new User());
		return "addUser";
	}
	
	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public String adduser(User user){
		//userDao.addUser(user); //with out hibernate using userDaoImpl
		userRepository.save(user); // with hibernate userDaoImpl is created automatic
		return "addUser";
	}

	@RequestMapping(value = "/findUser", method = RequestMethod.GET)
	public String finduser(Model model){
		/*List<String> userNameList = userDao.getUserNames();
		model.addAttribute("user", new User());
		model.addAttribute("userNameList", userNameList);*/
		List<String> userNameList = userRepository.findUserNames(new PageRequest(0,2));
		model.addAttribute("user", new User());
		model.addAttribute("userNameList", userNameList);
		return "findUser";
	}
	
	@RequestMapping(value = "/findAllUsers", method = RequestMethod.GET)
	public String findusers(Model model){
		/*List<String> userNameList = userDao.getUserNames();
		model.addAttribute("user", new User());
		model.addAttribute("userNameList", userNameList);*/
		List<String> userNameList = userRepository.findAllUserNames();
		model.addAttribute("user", new User());
		model.addAttribute("userNameList", userNameList);
		return "findAllUsers";
	}
	
	@RequestMapping(value = "/findUser", method = RequestMethod.POST)
	public String finduser(User user,Model model){
		/*User user1 = userDao.findUser(user);
		model.addAttribute("model", user1);*/
		User user1 = userRepository.findOne(user.getUsername());
		model.addAttribute("model", user1);
		return "showUser";
	}
	
	@RequestMapping(value = "/updateordelete", method = RequestMethod.POST, params="delete")
	public String deleteuser(User user){
		userRepository.delete(user);
		//userDao.deleteUser(user);	
		return "userdeleted";
	}
	
	@RequestMapping(value = "/updateordelete", method = RequestMethod.POST, params="update")
	public String updateuser(User user){
		userRepository.save(user);
		//userDao.updateUser(user);
		return "userupdated";
	}
}
