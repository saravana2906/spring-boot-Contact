package com.contacts.entity;

import javax.persistence.*;

import com.contacts.forms.SignupForm;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Slf4j
@Entity
//@Table(name = "users")
public class User {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long userid;
	private String username;
	private String emailid;
	private String phoneno;
	private String password;
	
	public User(long userid,String username,String emailid,String phoneno,String password)
	{
		log.info("creating user object");
		this.userid=userid;
		this.username=username;
		this.emailid=emailid;
		this.phoneno=phoneno;
		this.password=password;
		
	}
	
	public User(SignupForm signup)
	{
		this.username=signup.getUsername();
		this.emailid=signup.getEmailid();
		this.phoneno=signup.getPhoneno();
		this.password=signup.getPassword();
		
	}
	
}