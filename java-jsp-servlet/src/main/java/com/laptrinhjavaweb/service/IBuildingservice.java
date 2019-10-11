package com.laptrinhjavaweb.service;

import java.util.List;

import com.laptrinhjavaweb.buider.BuildingSeachBuilder;
import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.paging.Pageable;

public interface IBuildingservice {

	List<BuildingDTO> findAll(BuildingSeachBuilder filedSearch, Pageable pageable);
}
