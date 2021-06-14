package com.spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.beans.InputBean;
import com.spring.beans.ItemBean;
import com.spring.repository.CartRepository;

@RequestMapping("cart.htm")
@Controller
@SessionAttributes({"itemlist","inputbean"})
public class CartController {
	@Autowired
	private CartRepository cartrepo;
	
	
	@RequestMapping(method=RequestMethod.GET)
	public String loadCartPage(Model model) 
	{
		model.addAttribute("inputbean", new InputBean());
		model.addAttribute("itemlist",cartrepo.getallitems());		
		return "cart";
	}
	
	@RequestMapping(method=RequestMethod.POST, params="addtocart")
	public String processAddToCart(@ModelAttribute("itemlist") ArrayList<ItemBean> itemlist, 
									@ModelAttribute("inputbean") InputBean inputbean) 
	{
		System.out.println(inputbean.getQuantities().toString());
		return "cart";
	}
	
	@RequestMapping(method=RequestMethod.POST, params="checkout")
	public String processCheckOut(RedirectAttributes redirectattributes,
										@ModelAttribute("itemlist") ArrayList<ItemBean> itemlist,
										@ModelAttribute("inputbean") InputBean inputbean ) 
	{
		redirectattributes.addFlashAttribute("itemlist",itemlist);
		redirectattributes.addFlashAttribute("inputbean",inputbean);
		
		return "redirect:/summary.htm";
	}
	
}
