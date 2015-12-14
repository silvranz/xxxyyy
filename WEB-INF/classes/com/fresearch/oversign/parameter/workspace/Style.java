package com.fresearch.oversign.parameter.workspace;

public class Style{
	private String background_color;
	private String background;
	private String display;
	
	public Style(){}
	
	public void setBackground_color(String background_color){
		this.background_color = background_color;
	}
	public String getBackground_color(){
		return this.background_color;
	}
	public void setBackground(String background){
		this.background = background;
	}
	public String getBackground(){
		return this.background;
	}
	public void setDisplay(String display){
		this.display = display;
	}
	public String getDisplay(){
		return this.display;
	}
}