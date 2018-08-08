package com.contacts.aspects;

import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import com.contacts.ContactsManagementApplication;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

@Aspect
@Configuration
@Slf4j
public class ControllerAspect {
	@Autowired 
	 private HttpSession httpSession;
	
/*
	@Before("execution(* com.contacts.controller.*.*(..))")
	public void logControllers(JoinPoint joinPoint)
	{
		log.info("Starting of Advice");
		log.info("Method Name : "+ joinPoint.toString()+" Args : "+joinPoint.getArgs());
		log.info("Ending of Advice");
		
	}*/
	
	@Around("execution(* com.contacts.controller.*.*(..))")
	public Object sessionChecker(ProceedingJoinPoint joinPoint)
	{
		Object value=null;
		log.info("Starting of Advice");
		log.info("Method Name : "+ joinPoint.toString()+" Args : "+joinPoint.getArgs());
		System.out.println(httpSession.getAttribute("login"));
		if(null== httpSession.getAttribute("login") || httpSession.getAttribute("login").toString().equals("null") )
		{
			if(joinPoint.toString().toLowerCase().indexOf("signup")>-1 || joinPoint.toString().toLowerCase().indexOf("signin")>-1)
			{
				log.info("No Login Session");
				try {
					log.info("Calling Unprotected servlets");
					value=joinPoint.proceed();
				} catch (Throwable e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
			}
			else
			{
				return "redirect:/show_signin";
			}
		}
		else
		{
			if(Boolean.parseBoolean((String)httpSession.getAttribute("login")))
			{
				if(joinPoint.toString().toLowerCase().indexOf("signup")<0 && joinPoint.toString().toLowerCase().indexOf("signin")<0)
				{
					log.info("Session checked");
					try {
						log.info("Calling protected servlets");
						value=joinPoint.proceed();
						} catch (Throwable e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}	
				}
				else
				{
					log.info("Redirect protected Users");
					return "redirect:/home";	
				}	
			}	
		}
		return  value;
		
	}
	

}
