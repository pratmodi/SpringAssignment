package com.spring.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.spring.beans.InputBean;
import com.spring.beans.ItemBean;
import com.spring.beans.SummaryBean;

@Component
public class SummaryServices {

	private static int total = 0;
	private static List<ItemBean> selecteditems = new ArrayList<>();
	
	public SummaryBean getpopulatedsummarybean(List<ItemBean> itemlist,InputBean inputbean) 
	{
		SummaryBean summarybean = new SummaryBean();
		for(ItemBean item: itemlist) {
			if(inputbean.getSelected().contains(Integer.toString(item.getId()))) {
				selecteditems.add(item);
				total = total + item.getPrice()*Integer.parseInt(inputbean.getQuantities().get(item.getId()-1));
			}
		}
		
		
		summarybean.setSelecteditems(selecteditems);
		summarybean.setTotal(total);
		
		return summarybean;
	}
	
	
}
