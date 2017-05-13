package com.revature.dao.util;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.revature.beans.PeerOpinion;
import com.revature.beans.Rocket;
import com.revature.beans.User;
import com.revature.dao.PeerOpinionDAO;

@Transactional
public class PeerOpinionDAOImpl implements PeerOpinionDAO
{
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}
	
	
	@Override
	public boolean createOpinion(PeerOpinion opinion)
	{
		try
		{
			Session sesh = sessionFactory.getCurrentSession();
			if(getOpinion(opinion.getAuthor(), opinion.getRocket()) == null)
			{
				sesh.save(opinion);
				return true;
			}
			else
			{
				if(updateOpinion(opinion))
				{
					return true;
				}
				else
				{
					return false;
				}
			}
		}
		catch(HibernateException ex)
		{
			ex.printStackTrace();
			return false;
		}
		
	}

	@Override
	public PeerOpinion getOpinion(User author, Rocket rocket) 
	{
		try
		{
			Session sesh = sessionFactory.getCurrentSession();
			ArrayList<PeerOpinion> result = new ArrayList<PeerOpinion>();
			PeerOpinion opinion = null;
			
			result =  (ArrayList<PeerOpinion>) sesh.createQuery("FROM PeerOpinion WHERE rocket = "+ rocket.getRocketId()).list();

			
			for(int i = 0; i < result.size(); i++)
			{
				if(result.get(i).getAuthor().getId() == author.getId())
				{
					opinion = result.get(i);
				}
			}
			return opinion;
		}
		catch(HibernateException ex)
		{
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public List<PeerOpinion> getOpinions() 
	{
		try
		{
			Session sesh = sessionFactory.getCurrentSession();
			ArrayList<PeerOpinion> opinions = new ArrayList<PeerOpinion>();
			

			opinions =  (ArrayList<PeerOpinion>) sesh.createQuery("FROM PeerOpinion").list();
			
			return opinions;
		}
		catch(HibernateException ex)
		{
			ex.printStackTrace();
			return null;
		}	
		
	}

	@Override
	public boolean updateOpinion(PeerOpinion opinion)
	{
		try
		{
			Session sesh = sessionFactory.getCurrentSession();
			if(opinion.getId() != 0)
			{
				sesh.update(opinion);
				return true;	
			}
			else
			{
				return false;
			}

		}
		catch(HibernateException ex)
		{
			ex.printStackTrace();
			return false;
		}	
	}

	@Override
	public boolean deleteOpinion(int opinionId) 
	{
		try
		{
			Session sesh = sessionFactory.getCurrentSession();
			PeerOpinion opinion = new PeerOpinion();
			opinion = (PeerOpinion)sesh.get(PeerOpinion.class, opinionId);
			if(opinion != null)
			{
				sesh.delete(opinion);
				return true;
			}
			else
			{
				return false;
			}
		}
		catch(HibernateException ex)
		{
			ex.printStackTrace();
			return false;
		}
	}

}
