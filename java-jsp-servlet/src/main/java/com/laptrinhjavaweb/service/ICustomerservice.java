
package com.laptrinhjavaweb.service;

import java.util.List;

import com.laptrinhjavaweb.buider.CustomerSearchBuilder;
import com.laptrinhjavaweb.dto.CustomerDTO;
import com.laptrinhjavaweb.paging.Pageable;

public interface ICustomerservice {
	List<CustomerDTO> findAll(CustomerSearchBuilder fieldSearch,Pageable pageable);
}
