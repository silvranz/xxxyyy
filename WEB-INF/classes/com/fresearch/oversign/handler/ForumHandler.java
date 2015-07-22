package com.fresearch.oversign;
import java.util.ArrayList;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.google.gson.Gson;
import com.fresearch.oversign.*;

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
			ArrayList<PHOObjects> phoData = null;
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
}