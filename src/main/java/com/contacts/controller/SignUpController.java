package com.contacts.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.contacts.entity.User;
import com.contacts.forms.SigninForm;
import com.contacts.forms.SignupForm;
import com.contacts.repository.UserRepository;
import com.contacts.util.MD5Util;

@Controller
public class SignUpController {
	
	@Autowired
	UserRepository userRepository;
	
	@GetMapping
    @RequestMapping("/show_signup")
	public String showSignupForm(Model theModel)
	{
		theModel.addAttribute("signup",new SignupForm());
		return "signup";
	}
	
	@RequestMapping("/process_signup")
	public String processForm(
			@Valid @ModelAttribute("signup") SignupForm signup,
			BindingResult bindingResult,Model theModel) throws IOException {
		
		if (bindingResult.hasErrors()) {
			 return "signup";
		}
		else {
			User user=new User(signup);
			user.setPassword(MD5Util.getMD5(user.getPassword()));
			userRepository.save(user);
			theModel.addAttribute("signin",new SigninForm());
			
			 return "signin";
		}
		
		
	}
	
	

}
