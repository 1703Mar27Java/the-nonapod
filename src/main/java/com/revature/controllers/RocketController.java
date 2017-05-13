package com.revature.controllers;


import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Base64;
import java.util.Base64.Decoder;


import javax.servlet.http.HttpServletRequest;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.AccessControlList;
import com.amazonaws.services.s3.model.GroupGrantee;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.Permission;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.revature.beans.Rocket;
import com.revature.dao.RocketDAO;
import com.revature.dao.UserDAO;
import com.revature.services.MyCredentials;

@Controller
@RequestMapping("/rocket")
public class RocketController {

@RequestMapping(value="", method=RequestMethod.POST)
public String userLogin(Model m, @RequestParam(value = "id") int id )
{
	AbstractApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
	RocketDAO rocketDao = (RocketDAO) ac.getBean("rocketDao");
	
	Rocket rocket = rocketDao.getRocket(id);
	
	m.addAttribute("rocket", rocket.getLayout());
	
	
return "build";
}


@RequestMapping(value="save", method=RequestMethod.POST)
public String saveRocket(Model m, HttpServletRequest request)
{	
	AbstractApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
    RocketDAO rocketDao = (RocketDAO) ac.getBean("rocketDao");
    UserDAO userDao = (UserDAO) ac.getBean("userDao");
    String keyName        = request.getParameter("key");
		AmazonS3 s3client = new AmazonS3Client(new MyCredentials());
		try {
			String bucketName     = "rockets";
			keyName        = request.getParameter("key");
		
			System.out.println(keyName);
			
			
		    System.out.println("Uploading a new object to S3 from a file\n");
		    
		    byte[] bImg64 = request.getParameter("image").getBytes();
		     Decoder dc = Base64.getDecoder();
		     byte[] img = dc.decode(bImg64);
		    
		    
		    InputStream is = new ByteArrayInputStream(img);
		    long length = img.length;
		    
		    ObjectMetadata md = new ObjectMetadata();
		    
		    md.setContentEncoding("png");
		    md.setContentType("image/png");
		    md.setContentLength(length);
		    
		    
		    
		   AccessControlList acl = new AccessControlList();
		   acl.grantPermission(GroupGrantee.AllUsers, Permission.Read);
		    s3client.putObject(new PutObjectRequest(bucketName, keyName, is, md));
		
		    
		 } catch (AmazonServiceException ase) {
		    System.out.println("Caught an AmazonServiceException, which " +
		    		"means your request made it " +
		            "to Amazon S3, but was rejected with an error response" +
		            " for some reason.");
		    System.out.println("Error Message:    " + ase.getMessage());
		    System.out.println("HTTP Status Code: " + ase.getStatusCode());
		    System.out.println("AWS Error Code:   " + ase.getErrorCode());
		    System.out.println("Error Type:       " + ase.getErrorType());
		    System.out.println("Request ID:       " + ase.getRequestId());
		} catch (AmazonClientException ace) {
		    System.out.println("Caught an AmazonClientException, which " +
		    		"means the client encountered " +
		            "an internal error while trying to " +
		            "communicate with S3, " +
		            "such as not being able to access the network.");
		    System.out.println("Error Message: " + ace.getMessage());
		   ace.printStackTrace();
		}
		
		
				String rocketData = request.getParameter("grid");
				String rocketName = request.getParameter("name");
				String userID = request.getParameter("userID");

				Rocket saveRocket = new Rocket();
				saveRocket.setLayout(rocketData);
				saveRocket.setOwner(userDao.getUser(1));
				saveRocket.setRocketName(rocketName);
				String rocketURL = "https://s3-us-west-2.amazonaws.com/rockets/"+keyName;
				saveRocket.setRocketPic(rocketURL);
				rocketDao.createRocket(saveRocket); 
		
		return "build";
}



}
