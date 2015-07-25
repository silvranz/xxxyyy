package com.fresearch.oversign.parameter;

public class RegisterParam{
	//attribut yang disamain dengan objek json yang dilempar
	private String email;
	private String password;
	private String confirmPass;
	
	//belom coba tapi dibilangnya harus ada constructor kosong
	public RegisterParam(){}
	
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
	public String getConfirmPass(){
		return confirmPass;
	}
	public void setConfirmPass(String confirmPass){
		this.confirmPass = confirmPass;
	}
}