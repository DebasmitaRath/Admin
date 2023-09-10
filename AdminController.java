package com.boot.aatral.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.aatral.dto.UserDto;
import com.boot.aatral.payloads.ApiResponse;
import com.boot.aatral.response.ResponseHandler;
import com.boot.aatral.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/user/api")
public class AdminController {

	@Autowired
	private UserService userService;

	@PostMapping("/createuser")
	public ResponseEntity<Object> createUser(@Valid @RequestBody UserDto userDto) {
		UserDto createUserDto = this.userService.createUser(userDto);
		return ResponseHandler.responseBuilder("New user details are given here", HttpStatus.OK, createUserDto);

	}

	@GetMapping("/getuser/{id}")
	public ResponseEntity<Object> getSingleUser(@PathVariable String id) {
		UserDto userDto = this.userService.getUser(id);
		return ResponseHandler.responseBuilder("User details are given here", HttpStatus.OK, userDto);

	}

	@PutMapping("/updateuser/{id}")
	public ResponseEntity<Object> updateUser(@RequestBody UserDto userDto, @PathVariable String id) {
		UserDto updateUser = this.userService.updateUser(userDto, id);
		return ResponseHandler.responseBuilder("Updated user details are given here", HttpStatus.OK, updateUser);
	}

	@DeleteMapping("/deleteuser/{id}")
	public ResponseEntity<ApiResponse> deleteById(@PathVariable String id) {
		this.userService.deleteUser(id);
		return new ResponseEntity<ApiResponse>(new ApiResponse("User deleted successfully", false), HttpStatus.OK);
	}

	@GetMapping("/getallusers")
	public ResponseEntity<Object> getAllUsers() {
		List<UserDto> allUsers = this.userService.getAllUsers();
		return ResponseHandler.responseBuilder("Requested user details are given here", HttpStatus.OK, allUsers);
	}

}
