package com.amzn.helpers;

import java.util.List;

public class DataObject {
	
	private String[] stockName;
	public DataObject(String[] sName) {
		this.stockName = sName;
	}
	
	public void setStockName(String[] sName) {
		this.stockName = sName;
	}
	
	public String[] getStockName() {
	  return this.stockName;
	}
}