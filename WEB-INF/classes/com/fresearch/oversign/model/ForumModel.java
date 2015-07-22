package com.fresearch.oversign.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import com.fresearch.oversign.data.PopularHashtagObj;

public class ForumModel 
{
	public ArrayList<PopularHashtagObj> GetPopularHashtag_M(Connection connection) throws Exception
	{
		ArrayList<PopularHashtagObj> phoData = new ArrayList<PopularHashtagObj>();
		try
		{
			PreparedStatement ps = connection.prepareStatement("SELECT userid,useremail,userfullname FROM userbasic ORDER BY userid DESC");
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				PopularHashtagObj phoObject = new PopularHashtagObj();
				phoObject.setUserID(rs.getString("userid"));
				phoObject.setUserEmail(rs.getString("useremail"));
				phoObject.setUserFullName(rs.getString("userfullname"));
				phoData.add(phoObject);
			}
			return phoData;
		}
		catch(Exception e)
		{
			throw e;
		}
	}
}