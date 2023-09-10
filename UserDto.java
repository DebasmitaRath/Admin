package com.boot.aatral.dto;

import com.boot.aatral.entity.Roles;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {
	private String id;
	@NotEmpty
	@Size(min = 4, message = "Username must be minimum of 4 characters")
	private String name;

	@Email(message = "Email address is not valid !!")
	@NotEmpty(message = "Email is required !!")
	@Column(unique = true)
	private String email;
	@NotEmpty
	@Size(min = 5, message = "Password should have at least 5 chsracters !!!")
	private String password;

	@NotEmpty
	@Size(min = 10, message = "Description should have at least 10 chsracters !!!")
	private String description;
	private long contactno;

	@NotEmpty
	@Size(min = 5, message = "Address should have at least 5 chsracters !!!")
	private String address;
//	@NotEmpty(message = "Roles should not be empty !!!")
	private Roles roles;
//	@Pattern(regexp = "^(true|false)$", message = "restartable field allowed input: true or false")
	private Boolean isactive;
}
