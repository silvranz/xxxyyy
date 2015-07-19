package com.fresearch.oversign.parameter;

public class registerParam{
	private String email;
	private String password;
	private String confirmPass;
	
	public String getEmail(){
		return email;
	}
	public void setEmail(String email){
		this.email = email;
	}
	public String getPassword(){
		return password;
	}
	public void setPassword(String password){
		this.password = password;
	}
	public String getConfirmPass(){
		return confirmPass;
	}
	public void setConfirmPass(String confirmPass){
		this.confirmPass = confirmPass;
	}
}