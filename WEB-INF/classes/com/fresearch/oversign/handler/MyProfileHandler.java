package com.fresearch.oversign.handler;
import java.util.ArrayList;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.google.gson.Gson;
import com.fresearch.oversign.data.MyProfileObj;
import com.fresearch.oversign.controller.MyProfileController;
import com.fresearch.oversign.parameter.MyProfileParam;

@Path("/myprofile")
public class MyProfileHandler {
	@POST
	@Path("/getprofile")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String GetProfile_H(MyProfileParam myprofileparam)
	{
		String mfc = "aaa";
		try 
		{
			/*ArrayList<MyProfileObj> mpoData = null;
			MyProfileController mpc= new MyProfileController();
			mpoData = mpc.GetProfile_C(myprofileparam);
			System.out.println("aaa");
			Gson gson = new Gson();
			mfc = gson.toJson(mpoData);*/
			System.out.println("masuk");
		}

		catch (Exception e)
		{
			System.out.println("Exception Error");
		}
		return mfc;
	}
}