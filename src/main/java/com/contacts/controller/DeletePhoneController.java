package com.contacts.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.contacts.entity.Contact;
import com.contacts.entity.ContactPhone;
import com.contacts.repository.ContactPhoneRepository;


@Controller
public class DeletePhoneController {
	
	@Autowired
	ContactPhoneRepository contactPhoneRepository;
	
	@RequestMapping("/delete_phone")
		public String deletePhoneNO(HttpServletRequest request)
	{
		System.out.println("Phone ID :"+ request.getParameter("phoneid")+" Phone ID : "+request.getParameter("phoneno")+ " Contact ID "+request.getParameter("contactid"));
		ContactPhone cp=new ContactPhone();
		cp.setPhoneID(Long.parseLong(request.getParameter("phoneid")));
		cp.setPhoneNo(request.getParameter("phoneno"));
		Contact c=new Contact();
				c.setContactId(Long.parseLong(request.getParameter("contactid")));
		cp.setContact(c);
		contactPhoneRepository.delete(cp);
		System.out.println("Phone No Deleted");
		
		return "redirect:/all_contacts";
	}

}
