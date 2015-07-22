package com.fresearch.oversign;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.fresearch.oversign.*;

public class ForumModel 
{
	public ArrayList<PhoObjects> GetPopularHashtag_M(Connection connection) throws Exception
	{
		ArrayList<PhoObjects> phoData = new ArrayList<PhoObjects>();
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
				phoData.add(feedObject);
			}
			return phoData;
		}
		catch(Exception e)
		{
			throw e;
		}
	}
}