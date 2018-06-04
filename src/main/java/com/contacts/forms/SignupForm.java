package com.contacts.forms;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.contacts.annotations.Matches;

import lombok.Getter;
import lombok.Setter;


@Matches.List({
	@Matches(first="password",second="confirmpassword",message="Password didn't match")
})
@Getter
@Setter
public class SignupForm {
	
	@NotNull(message="is required")
	@Size(min=1, message="Username should not be Empty")
	private String username;
	@NotNull(message="is required")
	@Size(min=1, message="Email should not be Empty")
	private String emailid;
	@NotNull(message="is required")
	@Size(min=1, message="Phone No should not be Empty")
	private String phoneno;
	@NotNull(message="is required")
	@Size(min=1, message="Password should not be Empty")
	private String password;
	@NotNull(message="is required")
	@Size(min=1, message="Password should not be Empty")
	private String confirmpassword;


}

