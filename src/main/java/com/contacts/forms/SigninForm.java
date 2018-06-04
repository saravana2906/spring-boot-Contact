package com.contacts.forms;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SigninForm {
	
	
	@NotNull
	@Size(min=1, message="Username should not be Empty")
	String userName;
	@NotNull
	@Size(min=1, message="Password should not be Empty")
	String password;

}
