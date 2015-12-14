package com.fresearch.oversign.parameter.workspace;

public class ElementAttribute{
	private String classes;
	private String type;
	private String value;
	private String element_type;
	private String parent_style;
	private String showall;
	private String id;
	private String src;
	private ElementStyle style;
	
	public ElementAttribute(){}
	
	public void setClasses(String classes){
		this.classes = classes;
	}
	public String getClasses(){
		return classes;
	}	
	public void setType(String type){
		this.type = type;
	}
	public String getType(){
		return type;
	}
	public void setValue(String value){
		this.value = value;
	}
	public String getValue(){
		return value;
	}
	public void setElement_type(String element_type){
		this.element_type = element_type;
	}
	public String getElement_type(){
		return element_type;
	}
	public void setParent_style(String parent_style){
		this.parent_style = parent_style;
	}
	public String getParent_style(){
		return parent_style;
	}
	public void setShowall(String showall){
		this.showall = showall;
	}
	public String getShowall(){
		return showall;
	}
	public void setSrc(String src){
		this.src = src;
	}
	public String getSrc(){
		return src;
	}
	public void setId(String id){
		this.id = id;
	}
	public String getId(){
		return this.id;
	}
	public void setStyle(ElementStyle style){
		this.style = style;
	}
	public ElementStyle getStyle(){
		return this.style;
	}
}