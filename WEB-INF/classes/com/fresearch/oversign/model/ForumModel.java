package com.fresearch.oversign.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import com.fresearch.oversign.data.PopularHashtagObj;
import com.fresearch.oversign.data.HotThreadObj;
import com.fresearch.oversign.data.ForumSearchObj;

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
	public ArrayList<ForumSearchObj> GetForumSearch_C(Connection connection, String search) throws Exception
	{
		ArrayList<ForumSearchObj> fsData = new ArrayList<ForumSearchObj>();
		try
		{
			PreparedStatement ps = connection.prepareStatement("{CALL GetForumSearchResult(?)}");
			ps.setString(1,search);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				ForumSearchObj fsObject = new ForumSearchObj();
				fsObject.setForumID(rs.getString("ForumID"));
				fsObject.setForumTitle(rs.getString("ForumTitle"));
				fsObject.setNumberOfComment(rs.getString("NumberOfComment"));
				fsObject.setNumberOfEye(rs.getString("NumberOfEye"));
				fsObject.setUserFullName(rs.getString("UserFullName"));
				fsObject.setForumCreatedDate(rs.getString("ForumCreatedDate"));
				fsData.add(fsObject);
			}
			return fsData;
		}
		catch(Exception e)
		{
			throw e;
		}
	}
}

/*
 CREATE  PROCEDURE `test`(IN Array_String VARCHAR(100))
    BEGIN
        SELECT * FROM Table_Name
        WHERE FIND_IN_SET(field_name_to_search, Array_String);
    
    END//;

*/