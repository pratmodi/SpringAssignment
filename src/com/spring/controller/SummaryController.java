package com.spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.beans.InputBean;
import com.spring.beans.ItemBean;
import com.spring.beans.SummaryBean;
import com.spring.services.SummaryServices;

@Controller
@RequestMapping("/summary.htm")
public class SummaryController {
	@Autowired
	private SummaryServices summaryservices;
	
	@RequestMapping(method=RequestMethod.GET)
	public String loadsummarypage(Model model,@ModelAttribute("itemlist") List<ItemBean> itemlist,
												@ModelAttribute("inputbean") InputBean inputbean) 
	{
		SummaryBean summarybean = summaryservices.getpopulatedsummarybean(itemlist,inputbean);
		model.addAttribute("summarybean", summarybean);
		
		
		return "summary";
	}
	
	@RequestMapping(method=RequestMethod.POST, params="backtocart")
	public String processBackToCart(@ModelAttribute("itemlist") ArrayList<ItemBean> itemlist, 
									@ModelAttribute("inputbean") InputBean inputbean) 
	{
		
		return "redirect:cart.htm";
	}
	
	@RequestMapping(method=RequestMethod.POST, params="checkout")
	public String processCheckOut( ) 
	{
		return "thanks";
	}
	

	
}
