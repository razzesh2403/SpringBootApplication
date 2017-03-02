package com.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mvc.beans.User;

@Controller
public class SecurityController {
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String userLogin(){

		return "login";
	}
}
