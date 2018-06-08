package com.contacts.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.contacts.entity.Contact;
import com.contacts.entity.ContactPhone;
import com.contacts.entity.User;
import com.contacts.forms.AddContactForm;
import com.contacts.forms.Multiform;
import com.contacts.forms.UpdateContactForm;
import com.contacts.repository.ContactPhoneRepository;
import com.contacts.repository.ContactRepository;

@Controller
public class UpdateContactController {
	
	@Autowired
	ContactRepository contactRepository;
	@Autowired
	ContactPhoneRepository contactPhoneRepository;
	
	@GetMapping
	@RequestMapping("/show_contact")
	public String updateForm(
			@Valid @ModelAttribute("multiform") Multiform multiform , BindingResult vResult , Model model,RedirectAttributes redirectAttributes,HttpSession httpSession )
	{
		if(vResult.hasErrors())
		{
			System.out.println("Has Errors");
			redirectAttributes.addFlashAttribute("error", "Please select contact");
			return "redirect:/all_contacts";
			
		}
		System.out.println(multiform.getContactId());
		Contact c=contactRepository.findByUseridandContactId((Long)httpSession.getAttribute("uid"), multiform.getContactId());
		System.out.println("Phone Listing");
		List<ContactPhone> phList=contactPhoneRepository.findByUseridandContactId((Long)httpSession.getAttribute("uid"), multiform.getContactId());
		for(ContactPhone cp : phList)
		{
			System.out.println(cp.getPhoneID() +"  "+cp.getPhoneNo());
		}
		model.addAttribute("con", c);
		model.addAttribute("phList", phList);
		System.out.println(c.getContactId()+" "+c.getName());
		return "edit_contact";
	}
	
	@RequestMapping("/update_contact")
	public String processForm(
			@ModelAttribute("updateContact") UpdateContactForm updateContact,HttpSession session)
	{
		
		System.out.println(updateContact.getContactid() +  updateContact.getEmailid() + updateContact.getName());
		Contact c=new Contact();
		c.setContactId(updateContact.getContactid());
		c.setEmailId(updateContact.getEmailid());
		c.setName(updateContact.getName());
		User u=new User();
		u.setUserid((Long)session.getAttribute("uid"));
		c.setUser(u);
		contactRepository.save(c);
		if(updateContact.getPhonenumber()!=null)
		{
		for(String ph : updateContact.getPhonenumber())
		{
			ContactPhone cp =new ContactPhone();
			cp.setPhoneNo(ph);
			cp.setContact(c);
			contactPhoneRepository.save(cp);
		}
		}
		
		return "redirect:/all_contacts";
	}
	

}
