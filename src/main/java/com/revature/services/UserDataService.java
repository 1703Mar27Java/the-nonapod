package com.revature.services;

import javax.servlet.http.HttpSession;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.ui.Model;

import com.revature.beans.User;
import com.revature.dao.UserDAO;

public class UserDataService 
{
	public static boolean getUserData(Model m, HttpSession sesh)
	{
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		UserDAO dao = (UserDAO) ac.getBean("userDao");
		
		
		User user = dao.getUser(sesh.getAttribute("userName").toString());
		
		if(!(null == user))
		{
			m.addAttribute("user", user);
			m.addAttribute("userRockets", user.getUserRockets());	
			return true;
		}
		
		return false;
	}
}
