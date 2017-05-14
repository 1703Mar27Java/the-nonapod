package com.revature.controllers;


import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Base64;
import java.util.Base64.Decoder;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
import com.revature.beans.User;
import com.revature.dao.RocketDAO;
import com.revature.dao.UserDAO;
import com.revature.services.MyCredentials;
import com.revature.services.PardonService;
import com.revature.services.SaveRocketService;
import com.revature.services.UserDataService;

@Controller
@RequestMapping("")
public class RocketController {

@RequestMapping(value="rocket", method=RequestMethod.POST)
public String userLogin(Model m, @RequestParam(value = "id") int id )
{
	AbstractApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
	RocketDAO rocketDao = (RocketDAO) ac.getBean("rocketDao");
	
	Rocket rocket = rocketDao.getRocket(id);
	
	m.addAttribute("rocket", rocket.getLayout());
	
	
return "build";
}

@RequestMapping(value="backtoGarage", method=RequestMethod.POST)
public String backtoGarage(Model m,HttpServletRequest requ)
{
	HttpSession sesh = requ.getSession();

	UserDataService.getUserData(m, sesh);
	return "garage";
	
}

@RequestMapping(value="newrocket", method=RequestMethod.POST)
public String newRocket(Model m, @RequestParam(value = "id") int level )
{

	
	m.addAttribute("level", level);
	
	
return "build";
}

@RequestMapping(value="removeRocket", method=RequestMethod.POST)
public String removeRocket(Model m,@RequestParam(value = "id") int rocketID)
{
	
	AbstractApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
    RocketDAO rocketDao = (RocketDAO) ac.getBean("rocketDao");
    
    rocketDao.deleteRocket(rocketID);

	return "garage";
	
}


@RequestMapping(value="save", method=RequestMethod.POST)
public String saveRocket(Model m, HttpServletRequest request)
{	
		SaveRocketService.SaveRocket(m,request);
		return "build";
}



@RequestMapping(value="removeFlag", method=RequestMethod.POST)
public String pardonRocket(Model m, @RequestParam(value = "id") int rocketId, HttpServletRequest request)
{
	PardonService.pardon(rocketId);
	return "garage";
}

}
