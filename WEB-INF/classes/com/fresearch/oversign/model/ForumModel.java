package com.fresearch.oversign.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import com.fresearch.oversign.data.PopularHashtagObj;
import com.fresearch.oversign.data.HotThreadObj;

public class ForumModel 
{
	public ArrayList<PopularHashtagObj> GetPopularHashtag_M(Connection connection) throws Exception
	{
		ArrayList<PopularHashtagObj> phoData = new ArrayList<PopularHashtagObj>();
		try
		{
			PreparedStatement ps = connection.prepareStatement("CALL GetPopularHashtag");
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				PopularHashtagObj phoObject = new PopularHashtagObj();
				phoObject.setHashtagID(rs.getString("HashtagID"));
				phoObject.setHashtag(rs.getString("Hashtag"));
				phoData.add(phoObject);
			}
			return phoData;
		}
		catch(Exception e)
		{
			throw e;
		}
	}

	public ArrayList<HotThreadObj> GetHotThread_M(Connection connection) throws Exception
	{
		ArrayList<HotThreadObj> htData = new ArrayList<HotThreadObj>();
		try
		{
			PreparedStatement ps = connection.prepareStatement("CALL GetHotThread");
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				HotThreadObj htObject = new HotThreadObj();
				htObject.setForumID(rs.getString("ForumID"));
				htObject.setForumTitle(rs.getString("ForumTitle"));
				htObject.setNumberOfComment(rs.getString("NumberOfComment"));
				htObject.setNumberOfEye(rs.getString("NumberOfEye"));
				htObject.setUserFullName(rs.getString("UserFullName"));
				htObject.setForumCreatedDate(rs.getString("ForumCreatedDate"));
				htData.add(htObject);
			}
			return htData;
		}
		catch(Exception e)
		{
			throw e;
		}
	}
}