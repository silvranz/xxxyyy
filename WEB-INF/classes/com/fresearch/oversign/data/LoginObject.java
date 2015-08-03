package com.fresearch.oversign.data;

public class LoginObject {
	private int userID;
	private String userfullname;
	private int isAdministrator;
	private String userStatus;
	
	public LoginObject(){
		userID = -1;
	}
	
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userid) {
		this.userID = userid;
	}
	public int getIsAdministrator() {
		return isAdministrator;
	}
	public void setIsAdministrator(int isAdministrator) {
		this.isAdministrator = isAdministrator;
	}
	public String getUserFullName() {
		return userfullname;
	}
	public void setUserFullName(String userfullname) {
		this.userfullname = userfullname;
	}
	public String getUserStatus() {
		return userStatus;
	}
	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}
}