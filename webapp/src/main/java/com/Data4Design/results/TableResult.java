package com.Data4Design.results;


public class TableResult extends Result{
    
	private String [][] data;
	TableResult(){
		
	}
	
	String [][] getData(String api) {
		//data = fillTable(api);
		return data;
	}
}