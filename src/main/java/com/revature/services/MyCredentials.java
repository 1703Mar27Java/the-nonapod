package com.revature.services;

import com.amazonaws.auth.AWSCredentials;

public class MyCredentials implements AWSCredentials {
	
	public MyCredentials(){
		super();
	}
	
	public String getAWSAccessKeyId() {
		
		return "AKIAJ2FFNYZVXDOPOHWQ";
	}

	public String getAWSSecretKey() {
		return "CtZ3bBx3ZelR7GX2XEB+hjKixhU1JrU+5/IN573v";
	}
}