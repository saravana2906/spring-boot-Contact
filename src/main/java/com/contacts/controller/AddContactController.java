package com.contacts.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.contacts.entity.Contact;
import com.contacts.entity.ContactPhone;
import com.contacts.forms.AddContactForm;
import com.contacts.forms.SignupForm;
import com.contacts.repository.ContactPhoneRepository;
import com.contacts.repository.ContactRepository;

@Controller
public class AddContactController {
	
	@Autowired
	HttpSession httpSession;
	@Autowired
	ContactRepository contactRepository;
	@Autowired
	ContactPhoneRepository contactPhoneRepository;

	@GetMapping
	@RequestMapping("/show_addcontact")
	public String showAddContactForm()
	{
		return "add_contact";
		
	}
	
	@RequestMapping("/process_addcontact")
	public String processContactForm(
			@Valid @ModelAttribute("contactform") AddContactForm contactform,
			BindingResult bindingResult,Model theModel)
	{
		if(bindingResult.hasErrors())
		{
			theModel.addAttribute("error","All Fields are mandatory");
			return "add_contact";
		}
		
		System.out.println("Creating Contact ...");
		Contact contact=new Contact(contactform,(Long)httpSession.getAttribute("uid"));
		contact=contactRepository.save(contact);
		for(String phoneno : contactform.getPhonenumber())
		{
			ContactPhone cphone=new ContactPhone();
			cphone.setContact(contact);
			cphone.setPhoneNo(phoneno);
			cphone=contactPhoneRepository.save(cphone);
			System.out.println("Phone no created for contact "+cphone.getPhoneID()  +cphone.getPhoneNo() );
			
		}
		
		return "home";
	}
}
