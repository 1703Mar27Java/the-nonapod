package com.revature.testDrivers;

import java.util.ArrayList;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.beans.PeerOpinion;
import com.revature.beans.Rocket;
import com.revature.beans.User;
import com.revature.dao.CommentDAO;
import com.revature.dao.PeerOpinionDAO;

public class PeerOpinionDriver 
{
	
	public static void main(String[] args) 
	{
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		PeerOpinionDAO dao = (PeerOpinionDAO) ac.getBean("peerOpinionDao");

		User user = new User();
		user.setId(4);

		Rocket rocket = new Rocket();
		rocket.setRocketId(6);
	

		PeerOpinion opinion = new PeerOpinion();
		opinion.setAuthor(user);
		opinion.setRocket(rocket);
		opinion.setOpinion("like");
	
		PeerOpinion opinion2 = new PeerOpinion();
		opinion2.setAuthor(user);
		opinion2.setRocket(rocket);
		opinion2.setOpinion("dislike");

		System.out.println(dao.createOpinion(opinion));
		
		ArrayList<PeerOpinion> opinions = new ArrayList<PeerOpinion>();
		opinions = (ArrayList<PeerOpinion>) dao.getOpinions();
		System.out.println(opinions.toString());
	}
}
