package com.fresearch.oversign.parameter.workspace;
import java.util.*;

public class Element{
	private String createdOnPage;
	private String id;
	private String tag;
	private String html;
	private ElementAttribute attribute;
	private List<Event> events;
	private List<ShowOnPage> showOnPage;
	
	public Element(){}
	
	public void setCreatedOnPage(String createdOnPage){
		this.createdOnPage = createdOnPage;
	}
	public String getCreatedOnPage(){
		return this.createdOnPage;
	}
	public void setId(String id){
		this.id = id;
	}
	public String getId(){
		return this.id;
	}
	public void setTag(String tag){
		this.tag = tag;
	}
	public String getTag(){
		return this.tag;
	}
	public void setHtml(String html){
		this.html = html;
	}
	public String getHtml(){
		return this.html;
	}
	public void setAttribute(ElementAttribute attribute){
		this.attribute = attribute;
	}
	public ElementAttribute getAttribute(){
		return this.attribute;
	}
	public void setEvents(List<Event> events){
		this.events = events;
	}
	public List<Event> getEvents(){
		return this.events;
	}
	public void setShowOnPage(List<ShowOnPage> showOnPage){
		this.showOnPage = showOnPage;
	}
	public List<ShowOnPage> getShowOnPage(){
		return this.showOnPage;
	}
}