package com.contacts.entity;

import java.util.List;


import javax.persistence.*;
import javax.validation.Valid;

import com.contacts.forms.AddContactForm;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
//@Table(name = "contacts")
public class Contact {
	
	public Contact(AddContactForm contactform,Long userId) {
		// TODO Auto-generated constructor stub
		this.setName(contactform.getName());
		this.setEmailId(contactform.getEmailid());
		this.user=new User();
		this.user.setUserid(userId);
		
	}
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long contactId;
	private String name;
	private String emailId;
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
	private User user;
	}
