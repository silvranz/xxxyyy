package com.fresearch.oversign.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import com.fresearch.oversign.data.MyProfileObj;

public class MyProfileModel 
{
	public ArrayList<MyProfileObj> GetProfile_M(Connection connection, String inUserID) throws Exception
	{
		ArrayList<MyProfileObj> mpData = new ArrayList<MyProfileObj>();
		try
		{
			System.out.println(inUserID);
			PreparedStatement ps = connection.prepareStatement("{CALL GetUserProfile(?)}");
			ps.setString(1,inUserID);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				System.out.println("next");
				MyProfileObj mpObject = new MyProfileObj();
				mpObject.setUserID(rs.getString("UserID"));
				/*mpObject.setUserEmail(rs.getString("UserEmail"));
				mpObject.setUserFullName(rs.getString("UserFullName"));
				mpObject.setUserPhoto(rs.getString("UserPhoto"));
				mpObject.setUserAddress(rs.getString("UserAddress"));
				mpObject.setUserCity(rs.getString("UserCity"));
				mpObject.setUserProvince(rs.getString("UserProvince"));
				mpObject.setUserCountry(rs.getString("UserCountry"));
				mpObject.setUserPostalCode(rs.getString("UserPostalCode"));
				mpObject.setPersonalUser(rs.getString("PersonalUser"));
				mpObject.setCompanyName(rs.getString("CompanyName"));
				mpObject.setCompanyAddress(rs.getString("CompanyAddress"));
				mpObject.setCompanyCity(rs.getString("CompanyCity"));
				mpObject.setCompanyProvince(rs.getString("CompanyProvince"));
				mpObject.setCompanyCountry(rs.getString("CompanyCountry"));
				mpObject.setCompanyPostalCode(rs.getString("CompanyPostalCode"));*/
				mpData.add(mpObject);
			}
			return mpData;
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			throw e;
		}
	}
}
