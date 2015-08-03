package com.fresearch.oversign.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.fresearch.oversign.data.LoginObject;

public class UserModel 
{
	public String Registration(Connection connection,String userEmail,String userPassword) throws Exception
	{
		String response = "Error Model";
		try
		{
			PreparedStatement ps = connection.prepareStatement("{call RegisterNewMember(?,?)}");
			ps.setString(1,userEmail);
			ps.setString(2,userPassword);
			ResultSet rs = ps.executeQuery();
			if(!rs.next())
			{
				response = "success";
			}
			else{
				response = "User already exists";
			}
		}
		catch(Exception e)
		{
			response = "success update";
			System.out.println(e.getMessage());
			throw e;
		}
		return response;
	}
	public LoginObject Login(Connection connection,String userEmail,String userPassword) throws Exception
	{
		LoginObject response = new LoginObject();
		try
		{
			PreparedStatement ps = connection.prepareStatement("{call GetUserLogin(?,?)}");
			ps.setString(1,userEmail);
			ps.setString(2,userPassword);
			ResultSet rs = ps.executeQuery();
			System.out.println("masuk");
			if(rs.next())
			{
				System.out.println("next");
				response.setUserID(rs.getInt("UserID"));
				response.setUserFullName(rs.getString("UserFullName"));
				response.setIsAdministrator(rs.getInt("isAdministrator"));
				response.setUserStatus(rs.getString("UserStatus"));
			}
		}
		catch(Exception e)
		{
			throw e;
		}
		return response;
	}
}