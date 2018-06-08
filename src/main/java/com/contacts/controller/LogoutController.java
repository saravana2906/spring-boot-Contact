package com.contacts.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LogoutController {
	
	@GetMapping
	@RequestMapping("/logout")
	public String logOut(HttpSession session)
	{
		session.invalidate();
		
		return "redirect:/show_signin";
	}
	
	@GetMapping
	@RequestMapping("/home")
	public String home(HttpSession session)
	{
		
		
		return "home";
	}

}
