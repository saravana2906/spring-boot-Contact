package com.contacts.forms;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddContactForm {
	@NotNull(message="is required")
	@Size(min=1, message="Username should not be Empty")
	String name;
	@NotNull(message="is required")
	@Size(min=1, message="Email ID should not be Empty")
	String emailid;
	@NotNull(message="is required")
	List<String> phonenumber;

} 
