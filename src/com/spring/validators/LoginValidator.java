package com.spring.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.spring.beans.LoginBean;
import com.spring.repository.LoginRepository;

@Component
public class LoginValidator implements Validator{
	@Autowired
	private LoginRepository loginrepo;
	
	@Override
	public boolean supports(Class arg0) {
		
		return LoginBean.class.isInstance(arg0);
	}

	@Override
	public void validate(Object arg0, Errors arg1) {
	
		LoginBean loginBean = (LoginBean) arg0;
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "username", "error.username", "Username cannot be empty!!");
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "password", "error.password", "Password cannot be empty!!");
		if(!loginrepo.authenticate(loginBean)) {
		arg1.rejectValue("username","error.username","Invalid info");
		arg1.rejectValue("password","error.password","Invalid info");
		};
	}
	
}
