package com.revature.services;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.ui.Model;

import com.revature.beans.User;
import com.revature.dao.UserDAO;

public class RegisterService 
{
	public static boolean registerUser(String username, String password, String email)
	{
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		UserDAO dao = (UserDAO) ac.getBean("userDao");
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setEmail(email);
		user.setFirstName("");
		user.setLastName("");
		user.setUserRole("user");
		
		if(dao.createUser(user))
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
}
