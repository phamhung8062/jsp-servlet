package com.laptrinhjavaweb.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.laptrinhjavaweb.converter.UserConverter;
import com.laptrinhjavaweb.dto.UserDTO;
import com.laptrinhjavaweb.repository.IUserRepository;
import com.laptrinhjavaweb.repository.impl.UserRepository;
import com.laptrinhjavaweb.service.IUserservice;


public  class UserService implements IUserservice {
	private IUserRepository userRepository;
	private UserConverter userConverter;
	public  UserService() {
		 userRepository = new UserRepository() ;
		 userConverter = new UserConverter();
	}
	public List<UserDTO> findAll(int offset,int limmit) {
		return (List<UserDTO>) userRepository.findAll(offset,limmit).stream().map(item -> userConverter.convertToDTO(item))
				.collect(Collectors.toList());
	}
}
