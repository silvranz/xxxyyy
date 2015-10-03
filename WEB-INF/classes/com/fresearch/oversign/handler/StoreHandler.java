package com.fresearch.oversign.handler;
import java.util.ArrayList;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;
import com.google.gson.Gson;

import com.fresearch.oversign.controller.StoreController;
import com.fresearch.oversign.data.TemplateCategoryData;
import com.fresearch.oversign.data.TemplateData;
import com.fresearch.oversign.parameter.TemplateParam;

@Path("/store")
public class StoreHandler {
	@GET
	@Path("/getAllTemplateCategory")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<TemplateCategoryData> getAllCategory()
	{
		ArrayList<TemplateCategoryData> responseObject = new ArrayList<TemplateCategoryData>();
		try 
		{
			StoreController storeController = new StoreController();
			responseObject = storeController.GetAllCategory();
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
		return responseObject;
	}
	@POST
	@Path("/getAllTemplate")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<TemplateData> getAllTemplate(TemplateParam templateParam)
	{
		ArrayList<TemplateData> responseObject = new ArrayList<TemplateData>();
		try 
		{
			StoreController storeController = new StoreController();
			responseObject = storeController.GetAllTemplate(templateParam);
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
		return responseObject;
	}
}