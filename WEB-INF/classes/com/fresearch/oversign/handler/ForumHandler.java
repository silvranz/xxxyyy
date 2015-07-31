package com.fresearch.oversign.handler;
import java.util.ArrayList;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.google.gson.Gson;
import com.fresearch.oversign.data.PopularHashtagObj;
import com.fresearch.oversign.data.HotThreadObj;
import com.fresearch.oversign.controller.ForumController;

@Path("/forum")
public class ForumHandler {
	@GET
	@Path("/getpopularhashtag")
	@Produces("application/json")
	public String GetPopularHashtag_H()
	{
		
		String pho = null;
		try 
		{
			ArrayList<PopularHashtagObj> phoData = null;
			ForumController fc= new ForumController();
			phoData = fc.GetPopularHashtag_C();
			Gson gson = new Gson();
			pho = gson.toJson(phoData);
		}

		catch (Exception e)
		{
			System.out.println("Exception Error");
		}
		return pho;
	}

	@GET
	@Path("/gethotthread")
	@Produces("application/json")
	public String GetHotThread_H()
	{
		
		String ht = null;
		try 
		{
			ArrayList<HotThreadObj> htData = null;
			ForumController fc= new ForumController();
			htData = fc.GetHotThread_C();
			Gson gson = new Gson();
			ht = gson.toJson(htData);
		}

		catch (Exception e)
		{
			System.out.println("Exception Error");
		}
		return ht;
	}
}