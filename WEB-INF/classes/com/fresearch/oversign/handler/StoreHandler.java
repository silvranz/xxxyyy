package com.fresearch.oversign.handler;
import java.util.ArrayList;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.google.gson.Gson;

import com.fresearch.oversign.controller.StoreController;
import com.fresearch.oversign.data.TemplateCategoryData;
import com.fresearch.oversign.data.TemplateData;
import com.fresearch.oversign.data.StringResponse;
import com.fresearch.oversign.parameter.TemplateParam;
import com.fresearch.oversign.parameter.workspace.StoreParam;

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
	@POST
	@Path("/saveStore")
	@Produces(MediaType.APPLICATION_JSON)
	public StringResponse getAllTemplate(StoreParam storeParam)
	{
		StringResponse responseObject = new StringResponse(0,"Unknown Error");
		try 
		{
			StoreController storeController = new StoreController();
			responseObject = storeController.SaveStore(storeParam);
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
		return responseObject;
	}
	/*@POST
	@Path("/uploadImage")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public Response uploadImage(@FormDataParam("file") InputStream fileInputStream,
								@FormDataParam("file") FormDataContentDisposition contentDispositionHandle)
	{
		try 
		{
			StoreController storeController = new StoreController();
			responseObject = storeController.SaveStore(storeParam);
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
		return responseObject;
	}*/
}