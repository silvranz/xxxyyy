package com.fresearch.oversign.controller;

@Path("/user")
public class UserController{
	
	@Path("/register")
	@POST
	@Consume("application/json")
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