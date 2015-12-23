package com.fresearch.oversign.handler;
import java.util.ArrayList;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
import com.google.gson.Gson;

import com.fresearch.oversign.controller.UserController;
import com.fresearch.oversign.controller.ProjectManager;
import com.fresearch.oversign.data.FeedObjects;
import com.fresearch.oversign.parameter.LoginParam;
import com.fresearch.oversign.parameter.RegisterParam;

@Path("/user")
public class UserHandler {
	//POST -> method post
	//Consume -> anotation buat tentuin jenis parameter yang dipake(karena kita kirim dari ajax tipenya JSON maka @Consumes(MediaType.APPLICATION_JSON))
	//RegisterParam -> class penampung json yang dilempar
	//Kalo mapping attributnya salah(dari ajax sama class java-nya) tomcatnya keluarin error dan responsenya jadi 500
	@POST
	@Path("/register")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String newUser(RegisterParam registerParam)
	{
		String responseObject = null;
		try 
		{
			UserController userController = new UserController();
			responseObject = userController.Register(registerParam);
		}
		catch (Exception e)
		{
			responseObject = "success update";
			System.out.println("Exception Error");
		}
		return responseObject;
	}
	
	@POST
	@Path("/login")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String loginUser(LoginParam loginParam){
		String responseString = null;
		try{
			UserController userController = new UserController();
			responseString = userController.Login(loginParam);
		}
		catch(Exception e){
			responseString = "Login Error";
		}
		return responseString;
	}
	@GET
	@Path("/mail")
	@Produces(MediaType.TEXT_PLAIN)
	public String sendEmail(){
		// Recipient's email ID needs to be mentioned.
		String to = "silvranz@gmail.com";

		// Sender's email ID needs to be mentioned
		String from = "silvranz@gmail.com";

		// Assuming you are sending email from localhost
		String host = "smtp.gmail.com";

		// Get system properties
		Properties properties = System.getProperties();

		// Setup mail server
		properties.setProperty("mail.smtp.host", host);

		// Get the default Session object.
		Session session = Session.getDefaultInstance(properties);
		String error = "error";
		try{
			// Create a default MimeMessage object.
			MimeMessage message = new MimeMessage(session);

			// Set From: header field of the header.
			message.setFrom(new InternetAddress(from));

			// Set To: header field of the header.
			message.addRecipient(Message.RecipientType.TO,
								  new InternetAddress(to));

			// Set Subject: header field
			message.setSubject("This is the Subject Line!");

			// Now set the actual message
			message.setText("This is actual message");

			// Send message
			Transport.send(message);
			error = "Sent message successfully....";
			System.out.println("success");
		}catch (MessagingException e) {
			error = e.getMessage();
			System.out.println("success");
		}
		return error;
	}
}