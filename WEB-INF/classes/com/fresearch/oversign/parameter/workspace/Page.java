package com.fresearch.oversign.parameter.workspace;
import java.util.*;

public class Page{
	private String id;
	private boolean is_homepage;
	private String name;
	private List<Element> elements;
	private Header header;
	private Footer footer;
	private Attribute attribute;
	
	public Page(){}
	
	public void setId(String id){
		this.id = id;
	}
	public String getId(){
		return this.id;
	}
	public void setIs_homepage(boolean is_homepage){
		this.is_homepage = is_homepage;
	}
	public boolean getIs_homepage(){
		return this.is_homepage;
	}
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return this.name;
	}
	public void setElements(List<Element> elements){
		this.elements = elements;
	}
	public List<Element> getElements(){
		return this.elements;
	}
	public void setHeader(Header header){
		this.header = header;
	}
	public Header getHeader(){
		return this.header;
	}
	public void setFooter(Footer footer){
		this.footer = footer;
	}
	public Footer getFooter(){
		return this.footer;
	}
	public void setAttribute(Attribute attribute){
		this.attribute = attribute;
	}
	public Attribute getAttribute(){
		return this.attribute;
	}
}