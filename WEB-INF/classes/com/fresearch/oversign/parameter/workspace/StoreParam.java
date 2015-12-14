package com.fresearch.oversign.parameter.workspace;
import java.util.*;

public class StoreParam{
	private String homepage;
	private String pagename;
	private List<Page> pages;
	
	public StoreParam(){}
	
	public void setHomepage(String homepage){
		this.homepage = homepage;
	}
	public String getHomepage(){
		return homepage;
	}
	public void setPagename(String pagename){
		this.pagename = pagename;
	}
	public String getPagename(){
		return this.pagename;
	}
	public void setPages(List<Page> pages){
		this.pages = pages;
	}
	public List<Page> getPages(){
		return this.pages;
	}
}