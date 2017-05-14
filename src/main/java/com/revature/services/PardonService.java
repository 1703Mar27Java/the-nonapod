package com.revature.services;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.beans.Rocket;
import com.revature.dao.PeerOpinionDAO;
import com.revature.dao.RocketDAO;

public class PardonService 
{
	public static void pardon(int rocketId)
	{
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		RocketDAO rocketDao = (RocketDAO)ac.getBean("rocketDao");
		PeerOpinionDAO opinionDao = (PeerOpinionDAO)ac.getBean("peerOpinionDao");
		Rocket newLeaseOnLife = rocketDao.getRocket(rocketId);
		
		for(int i = 0; i < newLeaseOnLife.getRocketOpinions().size(); i++)
		{
			if(newLeaseOnLife.getRocketOpinions().get(i).getOpinion().equals("flag"))
			{
				opinionDao.deleteOpinion(newLeaseOnLife.getRocketOpinions().get(i).getId());
			}
		}
	}
}
