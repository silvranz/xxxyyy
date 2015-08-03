package com.fresearch.oversign.parameter;

public class LoginParam{
	//attribut yang disamain dengan objek json yang dilempar
	private String email;
	private String password;
	
	//belom coba tapi dibilangnya harus ada constructor kosong
	public LoginParam(){}
	
	//sisanya setter getter biasa
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
}