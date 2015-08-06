package com.fresearch.oversign.model;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.fresearch.oversign.data.TemplateCategoryData;
import com.fresearch.oversign.data.TemplateData;

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
	public ArrayList<TemplateData> GetAllTemplate(Connection connection) throws Exception
	{
		ArrayList<TemplateData> response = new ArrayList<TemplateData>();
		try
		{
			PreparedStatement ps = connection.prepareStatement("{call GetTemplate()}");
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
}