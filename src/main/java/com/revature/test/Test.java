package com.revature.test;

import org.hibernate.Session;

import com.revature.dao.util.HibernateUtil;

public class Test {

	public static void main(String[] args) 
	{
		Session sesh = HibernateUtil.getSession();
		sesh.beginTransaction();
		sesh.close();
	}

}
