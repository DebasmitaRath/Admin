package com.boot.aatral.service.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.aatral.dto.UserDto;
import com.boot.aatral.entity.Roles;
import com.boot.aatral.entity.User;
import com.boot.aatral.exception.ResourceNotFoundException;
import com.boot.aatral.repository.UserRepository;
import com.boot.aatral.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public UserDto createUser(UserDto userDto) {
		User user = this.modelMapper.map(userDto, User.class);
		String id = UUID.randomUUID().toString().substring(0, 7);
		if (user.getRoles().equals(Roles.BU_MANAGER)) {
			user.setId("BU_" + id);
		} else if (user.getRoles().equals(Roles.TA_MANAGER)) {
			user.setId("TA_" + id);
		} else if (user.getRoles().equals(Roles.RECRUITER)) {
			user.setId("RR_" + id);
		}
		User newUser = this.userRepository.save(user);
		return this.modelMapper.map(newUser, UserDto.class);
	}

	@Override
	public UserDto getUser(String id) {
		User user = this.userRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
		return this.modelMapper.map(user, UserDto.class);
	}

	@Override
	public UserDto updateUser(UserDto userDto, String id) {
		User user = this.userRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
		user.setAddress(userDto.getAddress());
		user.setContactno(userDto.getContactno());
		user.setDescription(userDto.getDescription());
		user.setEmail(userDto.getEmail());
		user.setId(userDto.getId());
		user.setIsactive(userDto.getIsactive());
		user.setName(userDto.getName());
		user.setPassword(userDto.getPassword());
		user.setRoles(userDto.getRoles());

		User updateUser = this.userRepository.save(user);
		return this.modelMapper.map(updateUser, UserDto.class);
	}

	@Override
	public void deleteUser(String id) {
		User user = this.userRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
		user.setIsactive(false);
		this.userRepository.save(user);
	}

	@Override
	public List<UserDto> getAllUsers() {
		List<User> user = this.userRepository.findAll();
		List<UserDto> userDtos = user.stream().map((item) -> this.modelMapper.map(item, UserDto.class))
				.collect(Collectors.toList());
		return userDtos;
	}

}
