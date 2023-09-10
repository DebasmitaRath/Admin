package com.boot.aatral.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
	@Id
	private String id;
	private String name;
	private String email;
	private String password;
	private String description;
	
	private long contactno;
	private String address;
	@Enumerated(EnumType.STRING)
	private Roles roles;
	private boolean isactive;
}
