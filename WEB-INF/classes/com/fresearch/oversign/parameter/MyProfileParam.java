package com.fresearch.oversign.parameter;

public class MyProfileParam{
	//attribut yang disamain dengan objek json yang dilempar
	private String userid;
	
	//belom coba tapi dibilangnya harus ada constructor kosong
	public MyProfileParam(){}
	
	//sisanya setter getter biasa
	public String getUserID(){
		return userid;
	}
	public void setUserID(String userid){
		this.userid = userid;
	}
}