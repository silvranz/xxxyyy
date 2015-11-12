package com.fresearch.oversign.controller;
import java.sql.Connection;
import java.util.ArrayList;
import com.fresearch.oversign.data.TemplateCategoryData;
import com.fresearch.oversign.data.TemplateData;
import com.fresearch.oversign.data.StringResponse;
import com.fresearch.oversign.model.StoreModel;
import com.fresearch.oversign.utility.Database;
import com.fresearch.oversign.parameter.TemplateParam;
import com.fresearch.oversign.parameter.StoreParam;

public class StoreController {
	public ArrayList<TemplateCategoryData> GetAllCategory()throws Exception {
		ArrayList<TemplateCategoryData> listCategory = new ArrayList<TemplateCategoryData>();
		try {
			Database database= new Database();
			Connection connection = database.Get_Connection();
			StoreModel storeModel= new StoreModel();
			listCategory = storeModel.GetAllCategory(connection);
		}
		catch (Exception e) {
			throw e;
		}
		return listCategory;
	}
	public ArrayList<TemplateData> GetAllTemplate(TemplateParam templateParam)throws Exception {
		ArrayList<TemplateData> listTemplate = new ArrayList<TemplateData>();
		try {
			Database database= new Database();
			Connection connection = database.Get_Connection();
			StoreModel storeModel= new StoreModel();
			int limit = templateParam.getLimit();
			int sort = templateParam.getSort();
			int offset = templateParam.getOffset();
			int categoryId = templateParam.getCategoryId();
			listTemplate = storeModel.GetAllTemplate(connection,limit,sort,offset,categoryId);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
			throw e;
		}
		return listTemplate;
	}
	
	public StringResponse SaveStore(StoreParam storeParam) throws Exception{
		StringResponse response = new StringResponse(0,"Error Validation");
		try{
			Database database= new Database();
			Connection connection = database.Get_Connection();
			StoreModel storeModel= new StoreModel();
			response = storeModel.SaveStore(connection,limit,sort,offset,categoryId);
		}
		catch (Exception e){
			System.out.println(e.getMessage());
			throw e;
		}
		return response;
	}
}