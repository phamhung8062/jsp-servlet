package com.laptrinhjavaweb.converter;

import org.modelmapper.ModelMapper;
import com.laptrinhjavaweb.dto.UserDTO;
import com.laptrinhjavaweb.entity.UserEntity;

public class UserConverter {
	public UserDTO convertToDTO(UserEntity item) {
		ModelMapper modelMapper = new ModelMapper();
		UserDTO dto=modelMapper.map(item, UserDTO.class);
		return dto;
	}
}
