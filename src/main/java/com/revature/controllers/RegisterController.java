package com.revature.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class RegisterController 
{
	@RequestMapping(value="register", method=RequestMethod.GET)
	public String registerGET(Model m,  HttpServletRequest request)
	{
		HttpSession sesh = request.getSession();

		
		if(!(null == sesh.getAttribute("userLoggedIn")) && (sesh.getAttribute("userLoggedIn").equals(true)))
		{
			return "user";
		}
			
		else if(!(null == sesh.getAttribute("adminLoggedIn")) && (sesh.getAttribute("adminLoggedIn").equals(true)))
		{
			return "admin";
		}
		
		return "login";
	}
}
