package com.fresearch.oversign.model;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.fresearch.oversign.data.TemplateCategoryData;
import com.fresearch.oversign.data.TemplateData;
import com.fresearch.oversign.data.StringResponse;

public class StoreModel 
{
	public ArrayList<TemplateCategoryData> GetAllCategory(Connection connection) throws Exception
	{
		ArrayList<TemplateCategoryData> response = new ArrayList<TemplateCategoryData>();
		try
		{
			PreparedStatement ps = connection.prepareStatement("{call GetTemplateCategory()}");
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				TemplateCategoryData tempItem = new TemplateCategoryData();
				tempItem.setCategoryNumber(rs.getInt("TemplateCategoryID"));
				tempItem.setCategoryName(rs.getString("TemplateCategoryName"));
				response.add(tempItem);
			}
		}
		catch(Exception e)
		{
			throw e;
		}
		return response;
	}
	public ArrayList<TemplateData> GetAllTemplate(Connection connection,int limit,int sort,int offset,int categoryId) throws Exception
	{
		ArrayList<TemplateData> response = new ArrayList<TemplateData>();
		try
		{
			PreparedStatement ps = connection.prepareStatement("{call GetTemplate(?,?,?,?)}");
			ps.setInt(1,limit);
			ps.setInt(2,sort);
			ps.setInt(3,categoryId);
			ps.setInt(4,offset);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				TemplateData tempItem = new TemplateData();
				tempItem.setTemplateNumber(rs.getInt("TemplateID"));
				tempItem.setTemplateName(rs.getString("TemplateTitle"));
				tempItem.setTemplateDesc(rs.getString("TemplateDescription"));
				tempItem.setPreviewImage(rs.getString("PreviewImage"));
				tempItem.setCategory(rs.getInt("TemplateCategoryID"));
				tempItem.setRating(rs.getInt("Rating"));
				tempItem.setSum(rs.getInt("SUM(Rating)"));
				tempItem.setUserRating(rs.getInt("COUNT(TemplateRatingID)"));
				tempItem.setCreatedDate(rs.getString("TemplateCreatedDate"));
				response.add(tempItem);
			}
		}
		catch(Exception e)
		{
			throw e;
		}
		return response;
	}
	
	public StringResponse SaveStore(Connection connection) throws Exception{
		StringResponse response = new StringResponse(0,"Data Rejected");
		try{
			//insert db
			response.setResponse(1);
			response.setMessage("Save succes");
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			throw e;
		}
		return response;
	}
}