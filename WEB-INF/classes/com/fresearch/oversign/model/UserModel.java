package com.fresearch.oversign.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.fresearch.oversign.utility.Encryption;

public class UserModel 
{
	public String Registration(Connection connection,String userEmail,String userPassword) throws Exception
	{
		String response = "Error Model";
		Encryption passwordEncryptor = new Encryption();
		try
		{
			PreparedStatement ps = connection.prepareStatement("{call RegisterNewMember(?,?)}");
			System.out.println(userEmail+":"+userPassword);
			ps.setString(1,userEmail);
			ps.setString(2,passwordEncryptor.PasswordEncription(userEmail,userPassword));
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				response = "detected next";
			}
		}
		catch(Exception e)
		{
			System.out.println("Model");
			throw e;
		}
		return response;
	}
}