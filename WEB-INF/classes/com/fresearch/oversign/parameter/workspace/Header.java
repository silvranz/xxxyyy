package com.fresearch.oversign.parameter.workspace;

public class Header{
	private String background_color;
	private String border_bottom_color;
	private String border_bottom_style;
	private String border_bottom_width;
	private String height;
	private String width;
	
	public Header(){}
	
	public void setBackground_color(String background_color){
		this.background_color = background_color;
	}
	public String getBackground_color(){
		return this.background_color;
	}
	public void setBorder_bottom_color(String border_bottom_color){
		this.border_bottom_color = border_bottom_color;
	}
	public String getBorder_bottom_color(){
		return this.border_bottom_color;
	}
	public void setBorder_bottom_style(String border_bottom_style){
		this.border_bottom_style = border_bottom_style;
	}
	public String getBorder_bottom_style(){
		return this.border_bottom_style;
	}
	public void setBorder_bottom_width(String border_bottom_width){
		this.border_bottom_width = border_bottom_width;
	}
	public String getBorder_bottom_width(){
		return this.border_bottom_width;
	}
	public void setHeight(String height){
		this.height = height;
	}
	public String getHeight(){
		return this.height;
	}
	public void setWidth(String width){
		this.width = width;
	}
	public String getWidth(){
		return this.width;
	}
}