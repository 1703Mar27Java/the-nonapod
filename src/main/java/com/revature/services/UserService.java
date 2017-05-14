package com.revature.services;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.beans.User;
import com.revature.dao.UserDAO;

public class UserService 
{
	public static void delete(int userId)
	{
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		UserDAO dao = (UserDAO)ac.getBean("userDao");
		
		dao.deleteUser(userId);
		
		
	}
	
	public static void promote(int userId)
	{
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		UserDAO dao = (UserDAO)ac.getBean("userDao");
		
		User newAdmin = dao.getUser(userId);
		newAdmin.setUserRole("admin");
		dao.updateUser(newAdmin);
	}
}
