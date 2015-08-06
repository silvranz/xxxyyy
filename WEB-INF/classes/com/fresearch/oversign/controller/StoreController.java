package com.fresearch.oversign.controller;
import java.sql.Connection;
import java.util.ArrayList;
import com.fresearch.oversign.data.TemplateCategoryData;
import com.fresearch.oversign.data.TemplateData;
import com.fresearch.oversign.model.StoreModel;
import com.fresearch.oversign.utility.Database;

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
	public ArrayList<TemplateData> GetAllTemplate()throws Exception {
		ArrayList<TemplateData> listTemplate = new ArrayList<TemplateData>();
		try {
			Database database= new Database();
			Connection connection = database.Get_Connection();
			StoreModel storeModel= new StoreModel();
			listTemplate = storeModel.GetAllTemplate(connection);
		}
		catch (Exception e) {
			throw e;
		}
		return listTemplate;
	}
}