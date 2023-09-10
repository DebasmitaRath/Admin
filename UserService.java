package com.boot.aatral.service;

import java.util.List;

import com.boot.aatral.dto.UserDto;

public interface UserService {

	UserDto createUser(UserDto userDto);

	UserDto getUser(String id);

	UserDto updateUser(UserDto userDto, String id);
	
	void deleteUser(String id);
	
	List<UserDto> getAllUsers();
}
