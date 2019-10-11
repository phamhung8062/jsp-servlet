package com.laptrinhjavaweb.converter;

import org.modelmapper.ModelMapper;

import com.laptrinhjavaweb.dto.CustomerDTO;
import com.laptrinhjavaweb.entity.CustomerEntity;

public class CustomerConverter {
	public CustomerDTO convertToDTO(CustomerEntity item) {
		ModelMapper modelMapper = new ModelMapper();
		CustomerDTO dto=modelMapper.map(item, CustomerDTO.class);
		return dto;
	}
}
