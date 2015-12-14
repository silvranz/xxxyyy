package com.fresearch.oversign.parameter.workspace;

public class ElementStyle{
	private String pointer_events;
	private String display;
	private String left;
	private String top;
	private String position;
	private String width;
	private String height;
	private String id;
	
	public ElementStyle(){}
	
	public void setPointer_events(String pointer_events){
		this.pointer_events = pointer_events;
	}
	public String getPointer_events(){
		return pointer_events;
	}
	public void setDisplay(String display){
		this.display = display;
	}
	public String getDisplay(){
		return display;
	}
	public void setLeft(String left){
		this.left = left;
	}
	public String getLeft(){
		return this.left;
	}
	public void setTop(String top){
		this.top = top;
	}
	public String getTop(){
		return this.top;
	}
	public void setPosition(String position){
		this.position = position;
	}
	public String getPosition(){
		return this.position;
	}
	public void setWidth(String width){
		this.width = width;
	}
	public String getWidth(){
		return this.width;
	}
	public void setHeight(String height){
		this.height = height;
	}
	public String getHeight(){
		return this.height;
	}
	public void setId(String id){
		this.id = id;
	}
	public String getId(){
		return this.id;
	}
}