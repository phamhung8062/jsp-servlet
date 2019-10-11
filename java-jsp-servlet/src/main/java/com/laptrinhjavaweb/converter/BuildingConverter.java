package com.laptrinhjavaweb.converter;

import org.modelmapper.ModelMapper;

import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.entity.BuildingEntity;

public class BuildingConverter {
 public BuildingDTO convertToDTO(BuildingEntity entity) {
	 ModelMapper modelMapper=new ModelMapper();
	 BuildingDTO dto=modelMapper.map(entity, BuildingDTO.class);
	 return dto;
 }
}
