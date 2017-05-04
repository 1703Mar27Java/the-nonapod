package com.revature.beans;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "COMMENTS")
public class Comments {

	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "commentSeq")
	@SequenceGenerator(allocationSize = 1, name = "commentSeq", sequenceName = "COMMENT_SEQ")
	@Column(name = "COMMENT_ID")
	private int id;
	
	@Column(name = "USER_COMMENT", nullable = false)
	private String comment;
	
	@ManyToOne
	@JoinColumn(name="USER_ID", nullable = false)
	private User author;
	
	@ManyToOne
	@JoinColumn(name="ROCKET_ID", nullable = false)
	private Rocket rocket;
	
	@Column(name = "DATE_CREATED", nullable = false)
	private Timestamp date;

	public int getId() 
	{
		return id;
	}

	public void setId(int id) 
	{
		this.id = id;
	}

	public String getComment() 
	{
		return comment;
	}

	public void setComment(String comment) 
	{
		this.comment = comment;
	}

	public User getAuthor()
	{
		return author;
	}

	public void setAuthor(User author)
{
		this.author = author;
	}

	public Rocket getRocket() 
	{
		return rocket;
	}

	public void setRocket(Rocket rocket) 
	{
		this.rocket = rocket;
	}

	public Timestamp getDate() 
	{
		return date;
	}

	public void setDate(Timestamp date) 
	{
		this.date = date;
	}

	@Override
	public String toString() 
	{
		return "Comments [id=" + id + ", comment=" + comment + ", author=" + author + ", rocket=" + rocket + ", date="
				+ date + "]";
	}

	public Comments(int id, String comment, User author, Rocket rocket, Timestamp date)
	{
		super();
		this.id = id;
		this.comment = comment;
		this.author = author;
		this.rocket = rocket;
		this.date = date;
	}

	public Comments() 
	{
	}


	

	
	
	
	

}
