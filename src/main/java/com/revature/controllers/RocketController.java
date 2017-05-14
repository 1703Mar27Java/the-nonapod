package com.revature.controllers;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.sql.*;

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
import com.revature.beans.Comment;
import com.revature.beans.PeerOpinion;
import com.revature.beans.Rocket;
import com.revature.beans.User;
import com.revature.dao.CommentDAO;
import com.revature.dao.PeerOpinionDAO;
import com.revature.dao.RocketDAO;
import com.revature.dao.UserDAO;
import com.revature.services.MyCredentials;
import com.revature.services.UserDataService;

@Controller
@RequestMapping("")
public class RocketController {

	@RequestMapping(value = "rocket", method = RequestMethod.POST)
	public String userLogin(Model m, @RequestParam(value = "id") int id) {
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		RocketDAO rocketDao = (RocketDAO) ac.getBean("rocketDao");

		Rocket rocket = rocketDao.getRocket(id);

		m.addAttribute("rocket", rocket.getLayout());

		return "build";
	}

	@RequestMapping(value = "backtoGarage", method = RequestMethod.POST)
	public String backtoGarage(Model m, HttpServletRequest requ) {
		HttpSession sesh = requ.getSession();

		UserDataService.getUserData(m, sesh);
		return "garage";

	}

	@RequestMapping(value = "newrocket", method = RequestMethod.POST)
	public String newRocket(Model m, @RequestParam(value = "id") int level) {

		m.addAttribute("level", level);

		return "build";
	}

	@RequestMapping(value = "removeRocket", method = RequestMethod.POST)
	public String removeRocket(Model m, @RequestParam(value = "id") int rocketID) {

		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		RocketDAO rocketDao = (RocketDAO) ac.getBean("rocketDao");

		rocketDao.deleteRocket(rocketID);

		return "garage";

	}

	@RequestMapping(value = "sendtoView", method = RequestMethod.POST)
	public String sendtoView(Model m, @RequestParam(value = "id") int id, HttpServletRequest requ) {
		HttpSession sesh = requ.getSession();
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		RocketDAO rocketDao = (RocketDAO) ac.getBean("rocketDao");

		Rocket rocket = rocketDao.getRocket(id);

		List<Comment> comments = rocket.getRocketComments();
		Collections.sort(comments, new Comparator<Comment>() {
			public int compare(Comment o1, Comment o2) {
				return o2.getDate().compareTo(o1.getDate());
			}
		});

		m.addAttribute("rocketURL", rocket.getRocketPic());
		m.addAttribute("rocketComments", comments);
		m.addAttribute("rocketName", rocket.getRocketName());
		m.addAttribute("rocketAuthor", rocket.getOwner().getUsername());
		m.addAttribute("rocketId", rocket.getRocketId());
		List<PeerOpinion> lD = rocket.getRocketOpinions();

		Boolean hasOpinion = false;

		String user = (String) sesh.getAttribute("userName");

		int like = 0;
		int dLike = 0;
		for (int i = 0; i < lD.size(); i++) {

			if (lD.get(i).getAuthor().getUsername().equals(user)) {
				hasOpinion = true;
			}

			if (lD.get(i).getOpinion().equals("like")) {
				like++;
			} else if (lD.get(i).getOpinion().equals("dislike")) {
				dLike++;
			}

		}

		m.addAttribute("rocketLikes", like);
		m.addAttribute("rocketDislikes", dLike);
		m.addAttribute("hasOpinion", hasOpinion);

		System.out.println(like + " " + dLike + " " + rocket.getRocketPic());

		return "view";
	}

	@RequestMapping(value = "like", method = RequestMethod.POST)
	public String likeRocket(Model m, @RequestParam(value = "id") int rocketID, HttpServletRequest request) {
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		PeerOpinionDAO peerDao = (PeerOpinionDAO) ac.getBean("peerOpinionDao");
		UserDAO userDao = (UserDAO) ac.getBean("userDao");
		HttpSession sesh = request.getSession();
		RocketDAO rocketDao = (RocketDAO) ac.getBean("rocketDao");

		String username = (String) sesh.getAttribute("userName");

		User user = userDao.getUser(username);
		Rocket rocket = rocketDao.getRocket(rocketID);

		PeerOpinion opinion = new PeerOpinion();

		opinion.setAuthor(user);
		opinion.setOpinion("like");
		opinion.setRocket(rocket);

		peerDao.createOpinion(opinion);

		return "view";

	}

	@RequestMapping(value = "dislike", method = RequestMethod.POST)
	public String dislikeRocket(Model m, @RequestParam(value = "id") int rocketID, HttpServletRequest request) {
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		PeerOpinionDAO peerDao = (PeerOpinionDAO) ac.getBean("peerOpinionDao");
		UserDAO userDao = (UserDAO) ac.getBean("userDao");
		HttpSession sesh = request.getSession();
		RocketDAO rocketDao = (RocketDAO) ac.getBean("rocketDao");

		String username = (String) sesh.getAttribute("userName");

		User user = userDao.getUser(username);
		Rocket rocket = rocketDao.getRocket(rocketID);

		PeerOpinion opinion = new PeerOpinion();

		opinion.setAuthor(user);
		opinion.setOpinion("dislike");
		opinion.setRocket(rocket);

		peerDao.createOpinion(opinion);

		return "view";

	}

	@RequestMapping(value = "comment", method = RequestMethod.POST)
	public String commentRocket(Model m, @RequestParam(value = "id") int rocketID,
			@RequestParam(value = "comment") String userComment, HttpServletRequest request) {
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		PeerOpinionDAO peerDao = (PeerOpinionDAO) ac.getBean("peerOpinionDao");
		UserDAO userDao = (UserDAO) ac.getBean("userDao");
		HttpSession sesh = request.getSession();
		RocketDAO rocketDao = (RocketDAO) ac.getBean("rocketDao");
		CommentDAO commentDao = (CommentDAO) ac.getBean("commentDao");

		String username = (String) sesh.getAttribute("userName");

		User user = userDao.getUser(username);
		Rocket rocket = rocketDao.getRocket(rocketID);

		Comment comment = new Comment();
		comment.setAuthor(user);
		comment.setRocket(rocket);
		comment.setComment(userComment);

		java.util.Date utilDate = new java.util.Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(utilDate);
		cal.set(Calendar.MILLISECOND, 0);

		comment.setDate(new java.sql.Timestamp(cal.getTimeInMillis()));

		commentDao.createComment(comment);

		return "view";

	}

	@RequestMapping(value = "flag", method = RequestMethod.POST)
	public String flagRocket(Model m, @RequestParam(value = "id") int rocketID, HttpServletRequest request) {
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		PeerOpinionDAO peerDao = (PeerOpinionDAO) ac.getBean("peerOpinionDao");
		UserDAO userDao = (UserDAO) ac.getBean("userDao");
		HttpSession sesh = request.getSession();
		RocketDAO rocketDao = (RocketDAO) ac.getBean("rocketDao");

		String username = (String) sesh.getAttribute("userName");

		User user = userDao.getUser(username);
		Rocket rocket = rocketDao.getRocket(rocketID);

		PeerOpinion opinion = new PeerOpinion();

		opinion.setAuthor(user);
		opinion.setOpinion("flag");
		opinion.setRocket(rocket);

		peerDao.createOpinion(opinion);

		return "view";

	}

	@RequestMapping(value = "save", method = RequestMethod.POST)
	public String saveRocket(Model m, HttpServletRequest request) {
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		RocketDAO rocketDao = (RocketDAO) ac.getBean("rocketDao");
		UserDAO userDao = (UserDAO) ac.getBean("userDao");
		String keyName = request.getParameter("key");
		AmazonS3 s3client = new AmazonS3Client(new MyCredentials());
		try {
			String bucketName = "rockets";
			keyName = request.getParameter("key");

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
			System.out.println("Caught an AmazonServiceException, which " + "means your request made it "
					+ "to Amazon S3, but was rejected with an error response" + " for some reason.");
			System.out.println("Error Message:    " + ase.getMessage());
			System.out.println("HTTP Status Code: " + ase.getStatusCode());
			System.out.println("AWS Error Code:   " + ase.getErrorCode());
			System.out.println("Error Type:       " + ase.getErrorType());
			System.out.println("Request ID:       " + ase.getRequestId());
		} catch (AmazonClientException ace) {
			System.out.println("Caught an AmazonClientException, which " + "means the client encountered "
					+ "an internal error while trying to " + "communicate with S3, "
					+ "such as not being able to access the network.");
			System.out.println("Error Message: " + ace.getMessage());
			ace.printStackTrace();
		}

		HttpSession sesh = request.getSession();

		String rocketData = request.getParameter("grid");
		String rocketName = request.getParameter("name");
		String username = (String) sesh.getAttribute("userName");

		User user = userDao.getUser(username);
		Rocket saveRocket = new Rocket();
		saveRocket.setLayout(rocketData);
		saveRocket.setOwner(user);
		saveRocket.setRocketName(rocketName);
		String rocketURL = "https://s3-us-west-2.amazonaws.com/rockets/" + keyName;
		saveRocket.setRocketPic(rocketURL);
		rocketDao.createRocket(saveRocket);

		return "build";
	}

}
