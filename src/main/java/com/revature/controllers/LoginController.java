package com.revature.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.revature.beans.User;
import com.revature.dao.UserDAO;


@Controller
@RequestMapping("/login")
public class LoginController 
{
	@RequestMapping(value="", method=RequestMethod.GET)
	public String userLogin(Model m)
	{
		return "view";
	}
	
	
	@RequestMapping(value="/all", method=RequestMethod.GET)
	public ResponseEntity<Object> getUsers()
	{
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		UserDAO dao = (UserDAO) ac.getBean("userDao");
		List<User> users = new ArrayList<User>();
		User user = new User();
		//user = dao.getUser(4);
		
		user.setFirstName("blah");
		user.setLastName("blahaah");
		user.setId(6);
		user.setPassword("blah");
		user.setUsername("blah");
		
		users = dao.getUsers();
		
		return ResponseEntity.ok(user);
	}
	
}
