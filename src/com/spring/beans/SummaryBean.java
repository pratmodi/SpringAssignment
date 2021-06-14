package com.spring.beans;

import java.util.List;

public class SummaryBean {

	private int total;
	private List<ItemBean> selecteditems;
	
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public List<ItemBean> getSelecteditems() {
		return selecteditems;
	}
	public void setSelecteditems(List<ItemBean> selecteditems) {
		this.selecteditems = selecteditems;
	}
	
	
	
	
	
}
