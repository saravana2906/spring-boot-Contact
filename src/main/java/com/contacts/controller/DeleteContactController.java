package com.contacts.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.contacts.entity.Contact;
import com.contacts.forms.Multiform;
import com.contacts.repository.ContactPhoneRepository;
import com.contacts.repository.ContactRepository;

@Controller
public class DeleteContactController {
	
	@Autowired
	ContactRepository contactRepository;
	@Autowired
	ContactPhoneRepository contactPhoneRepository;
	
	@Transactional
	@RequestMapping("/delete_contact")
	public String deleteContact(
			@Valid @ModelAttribute("multiform") Multiform multiform , BindingResult vResult , Model model,RedirectAttributes redirectAttributes,HttpSession httpSession)
	{
		if(vResult.hasErrors())
		{
			System.out.println("Has Errors");
			redirectAttributes.addFlashAttribute("error", "Please select contact");
			return "redirect:/all_contacts";
			
		}
		System.out.println(multiform.getContactId());
		Contact c=new Contact();
		c.setContactId(multiform.getContactId());
		
		contactPhoneRepository.deleteByContact(c);
		contactRepository.delete(c);
			
		
		
		return "redirect:/all_contacts";
	
	}
	
}
