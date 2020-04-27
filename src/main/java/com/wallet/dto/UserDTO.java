package com.wallet.dto;


import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

import lombok.Data;

@Data
public class UserDTO {

	private Long id;

	@Email(message = "e-mail is not valid")
	private String email;
	@Length(min=3, max=50, message = "name must contains between 3 or 50 characters")
	private String name;
	@NotNull
	@Length(min=6, message = "password must contains 6 characters or more")
	private String password;
	
	
	
}
