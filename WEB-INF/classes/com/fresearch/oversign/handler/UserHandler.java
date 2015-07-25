package com.fresearch.oversign.handler;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;
import com.google.gson.Gson;

import com.fresearch.oversign.parameter.RegisterParam;
import com.fresearch.oversign.controller.UserController;
import com.fresearch.oversign.data.FeedObjects;
import com.fresearch.oversign.controller.ProjectManager;
import java.util.ArrayList;

@Path("/user")
public class UserHandler {
	//POST -> method post
	//Consume -> anotation buat tentuin jenis parameter yang dipake(karena kita kirim dari ajax tipenya JSON maka @Consumes(MediaType.APPLICATION_JSON))
	//RegisterParam -> class penampung json yang dilempar
	//Kalo mapping attributnya salah(dari ajax sama class java-nya) tomcatnya keluarin error dan responsenya jadi 500
	@POST
	@Path("/register")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
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
			System.out.println("Exception Error");
		}
		return responseObject;
	}
}