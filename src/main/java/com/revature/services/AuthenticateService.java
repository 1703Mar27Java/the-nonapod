package com.revature.services;

import javax.servlet.http.HttpSession;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.ui.Model;

import com.revature.beans.User;
import com.revature.dao.UserDAO;

public class AuthenticateService 
{

	public static boolean validateUser(String username, String password, HttpSession sesh, Model m)
	{
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		UserDAO dao = (UserDAO) ac.getBean("userDao");
		
		
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		
		User credMatch = dao.getUser(username);
		
		if(	!(null == credMatch) && 
			!(null == user) &&
			(user.getUsername().equals(credMatch.getUsername()) && 
			(user.getPassword().equals(credMatch.getPassword()))))
		{		
			if(credMatch.getUserRole().equals("user"))
			{
				sesh.setAttribute("userLoggedIn", true);
			}
			else if(credMatch.getUserRole().equals("admin"))
			{
				sesh.setAttribute("adminLoggedIn", true);
			}
			m.addAttribute("user", credMatch);
			m.addAttribute("userRockets", credMatch.getUserRockets());

			sesh.setAttribute("userName", credMatch.getUsername());
			sesh.setAttribute("firstName", credMatch.getFirstName());
			sesh.setAttribute("lastName", credMatch.getLastName());
			return true;
		}
		else
		{
			return false;
		}
		
	}
}
