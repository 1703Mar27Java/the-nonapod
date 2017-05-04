package com.revature.beans;

import javax.persistence.*;


@Entity
@Table(name = "ROCKETS")
public class Rocket 
{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rocketSeq")
	@SequenceGenerator(allocationSize = 1, name = "rocketSeq", sequenceName = "ROCKET_SEQ")
	@Column(name = "ROCKET_ID")
	private int rocketId;
	
	@ManyToOne
	@JoinColumn(name="USER_ID", nullable = false)
	private User owner;
	
	@Column(name = "LAYOUT", nullable = false)
	private String layout;

	public int getRocketId() 
	{
		return rocketId;
	}

	public void setRocketId(int rocketId) 
	{
		this.rocketId = rocketId;
	}

	public User getOwner() 
	{
		return owner;
	}

	public void setOwner(User owner)
	{
		this.owner = owner;
	}

	public String getLayout() 
	{
		return layout;
	}

	public void setLayout(String layout) 
	{
		this.layout = layout;
	}

	@Override
	public String toString() 
	{
		return "Rocket [rocketId=" + rocketId + ", owner=" + owner + ", layout=" + layout + "]";
	}

	public Rocket(int rocketId, User owner, String layout) 
	{
		super();
		this.rocketId = rocketId;
		this.owner = owner;
		this.layout = layout;
	}

	public Rocket() 
	{
		super();
	}
}
