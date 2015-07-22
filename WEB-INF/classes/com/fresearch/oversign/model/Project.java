package com.fresearch.oversign.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.fresearch.oversign.data.FeedObjects;

public class Project 
{
	public ArrayList<FeedObjects> GetFeeds(Connection connection) throws Exception
	{
		ArrayList<FeedObjects> feedData = new ArrayList<FeedObjects>();
		try
		{
			PreparedStatement ps = connection.prepareStatement("SELECT userid,useremail,userfullname FROM userbasic ORDER BY userid DESC");
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				FeedObjects feedObject = new FeedObjects();
				feedObject.setUserID(rs.getString("userid"));
				feedObject.setUserEmail(rs.getString("useremail"));
				feedObject.setUserFullName(rs.getString("userfullname"));
				feedData.add(feedObject);
			}
			return feedData;
		}
		catch(Exception e)
		{
			throw e;
		}
	}
}