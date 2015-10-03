package com.fresearch.oversign.parameter;

public class TemplateParam{
	//attribut yang disamain dengan objek json yang dilempar
	private int limit;
	private int sort;
	private int offset;
	private int categoryId;
	
	//belom coba tapi dibilangnya harus ada constructor kosong
	public TemplateParam(){}
	
	//sisanya setter getter biasa
	public int getLimit(){
		return limit;
	}
	public void setLimit(int limit){
		this.limit = limit;
	}
	public int getSort(){
		return sort;
	}
	public void setSort(int sort){
		this.sort = sort;
	}
	public int getOffset(){
		return offset;
	}
	public void setOffset(int offset){
		this.offset = offset;
	}
	public int getCategoryId(){
		return categoryId;
	}
	public void setCategoryId(int categoryId){
		this.categoryId = categoryId;
	}
}