
package com.laptrinhjavaweb.service;

import java.util.List;

import com.laptrinhjavaweb.buider.BuildingSeachBuilder;
import com.laptrinhjavaweb.buider.UserSearchBuilder;
import com.laptrinhjavaweb.dto.UserDTO;
import com.laptrinhjavaweb.paging.Pageable;

public interface IUserservice {
	List<UserDTO> findAll(UserSearchBuilder fieldSearch,Pageable pageable);
}