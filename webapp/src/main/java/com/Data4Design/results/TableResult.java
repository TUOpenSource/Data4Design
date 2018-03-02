package com.Data4Design.results;


public class TableResult extends Result{
    
	String [][] data;
	TableResult(){
		
	}
	
	String [][] fetchData(String api) {
		//data = fillTable(api);
		return data;
	}
}