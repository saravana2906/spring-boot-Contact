package com.contacts.forms;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Multiform {
	
	@NotNull
	@Range(min=1,message="Select the contact")
	Long contactId;

}
