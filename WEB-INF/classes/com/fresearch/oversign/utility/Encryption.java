package com.fresearch.oversign.utility;

import java.security.MessageDigest;

public class Encryption {
	private String specialSalt = "0v3rS1gn&Fr3s34rcH&4Pl1c4t10N";
	public Encryption(){}
	
	public String PasswordEncription(String password,String email) throws Exception
	{
		String result = "Error";
		try
		{
			MessageDigest messageDigest = MessageDigest.getInstance("MD5");
			messageDigest.update((email+specialSalt).getBytes("UTF-8"));
			messageDigest.update(password.getBytes("UTF-8"));			
			byte raw[] = messageDigest.digest();
			String encode = "";
			for (int i = 0; i < raw.length; i++) {
			  encode += Integer.toHexString((0x000000ff & raw[i]) | 0xffffff00).substring(6);
			}
			result = encode;
		}
		catch (Exception e)
		{
			System.out.println("encryption");
            e.printStackTrace();
		}
		return result;
	}

}
