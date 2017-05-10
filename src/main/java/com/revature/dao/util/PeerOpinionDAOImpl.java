package com.revature.dao.util;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.revature.beans.PeerOpinion;
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
			sesh.saveOrUpdate(opinion.getAuthor());
			sesh.saveOrUpdate(opinion.getRocket());
			sesh.save(opinion);

			return true;
		}
		catch(HibernateException ex)
		{
			ex.printStackTrace();
			return false;
		}
		
	}

	@Override
	public PeerOpinion getOpinion(int opinionId) 
	{
		try
		{
			Session sesh = sessionFactory.getCurrentSession();
			ArrayList<PeerOpinion> result = new ArrayList<PeerOpinion>();
			PeerOpinion opinion = new PeerOpinion();
			

			result =  (ArrayList<PeerOpinion>) sesh.createQuery("FROM PeerOpinion WHERE id =" + opinionId).list();
			
			if(result.size() > 0)
			{
				opinion = result.get(0);
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
	public List<PeerOpinion> getUsers() 
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
				sesh.saveOrUpdate(opinion.getAuthor());
				sesh.saveOrUpdate(opinion.getRocket());
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