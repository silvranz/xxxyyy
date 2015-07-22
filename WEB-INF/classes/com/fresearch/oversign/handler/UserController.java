package com.fresearch.oversign.handler;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import com.google.gson.Gson;
import com.fresearch.oversign.parameter.registerParam;

@Path("/user")
public class UserController{
	
	@Path("/register")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String registerNewUser(registerParam registerParam){
		String registerResponse = null;
		try 
		{
			Gson gson = new Gson();
			registerResponse = gson.toJson(registerParam);
		}

		catch (Exception e)
		{
			System.out.println("Exception Error");
		}
		return registerResponse;
	}
}