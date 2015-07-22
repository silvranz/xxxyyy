package com.fresearch.oversign.handler;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.google.gson.Gson;
import com.fresearch.oversign.data.FeedObjects;
import com.fresearch.oversign.controller.ProjectManager;

@Path("/engine")
public class EngineResource {
	@GET
	@Path("/get")
	@Produces("application/json")
	public String feed()
	{
		String feeds = null;
		try 
		{
			ArrayList<FeedObjects> feedData = null;
			ProjectManager projectManager= new ProjectManager();
			feedData = projectManager.GetFeeds();
			Gson gson = new Gson();
			//System.out.println(gson.toJson(feedData));
			feeds = gson.toJson(feedData);
		}

		catch (Exception e)
		{
			System.out.println("Exception Error");
		}
		return feeds;
	}
}