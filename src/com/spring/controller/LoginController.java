package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.spring.beans.LoginBean;
import com.spring.validators.LoginValidator;

@RequestMapping("login.htm")
@Controller
@SessionAttributes("loginBean")
public class LoginController {
	
	@Autowired
	private LoginValidator loginValidator;
	
	@RequestMapping(method=RequestMethod.GET)
	public String loadloginpage(Model model) 
	{
		
		model.addAttribute("loginBean",new LoginBean());
		return "login";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String processloginpage(@ModelAttribute("loginBean") LoginBean loginBean, 
									BindingResult errors) 
	{
		loginValidator.validate(loginBean, errors);
		if(errors.hasErrors()) {
			return "login";
		}
		return "redirect:/cart.htm";
	}
	
}
