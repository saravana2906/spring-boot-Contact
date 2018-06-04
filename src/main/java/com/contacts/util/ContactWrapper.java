package com.contacts.util;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ContactWrapper {
	
	private long contactId;
	private String name;
	private String emailId;
	private ArrayList<String> phList;
	

	public ContactWrapper()
	{
		this.phList=new ArrayList<String>();
	}
}


