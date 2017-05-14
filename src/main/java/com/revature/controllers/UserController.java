package com.revature.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.revature.services.UserService;

@RequestMapping(value="")
@Controller
public class UserController 
{
	@RequestMapping(value="deleteUser", method=RequestMethod.POST)
	public String deleteUser(Model m, @RequestParam(value="userDeleteId") int userId, HttpServletRequest request)
	{
		HttpSession sesh = request.getSession();
		UserService.delete(userId);
		return "admin";
	}
	

	@RequestMapping(value="userPromote", method=RequestMethod.POST)
	public String promoteUser(Model m, @RequestParam(value="userPromoteId") int userId, HttpServletRequest request)
	{
		HttpSession sesh = request.getSession();
		UserService.promote(userId);
		return "admin";
	}
}


