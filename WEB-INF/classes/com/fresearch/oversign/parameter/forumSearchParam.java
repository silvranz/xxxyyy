package com.fresearch.oversign.parameter;

public class ForumSearchParam{
	//attribut yang disamain dengan objek json yang dilempar
	private String search;
	
	//belom coba tapi dibilangnya harus ada constructor kosong
	public ForumSearchParam(){}
	
	//sisanya setter getter biasa
	public String getSearch(){
		return search;
	}
	public void setSearch(String search){
		this.search = search;
	}
}