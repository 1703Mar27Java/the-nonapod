package com.revature.dao;

import java.util.List;

import com.revature.beans.PeerOpinion;


public interface PeerOpinionDAO 
{
	public boolean createOpinion(PeerOpinion opinion);
	
	public PeerOpinion getOpinion(int opinionId);
	public List<PeerOpinion> getOpinions();
	
	public boolean updateOpinion(PeerOpinion opinion);
	
	public boolean deleteOpinion(int opinionId);
}
