package com.fresearch.oversign.data;

public class StringResponse {
	private int response;
	private String message;
	
	public StringResponse(int defResponse,String defMessage){
		this.response = defResponse;
		this.message = defMessage;
	}
	
	public void setResponse(int response){
		this.response = response;
	}
	public int getResponse(){
		return response;
	}
	public void setMessage(String message){
		this.message = message;
	}
	public String getMessage(){
		return message;
	}
}