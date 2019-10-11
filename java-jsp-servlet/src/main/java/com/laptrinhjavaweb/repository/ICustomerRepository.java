package com.laptrinhjavaweb.repository;

import java.util.List;
import java.util.Map;

import com.laptrinhjavaweb.buider.CustomerSearchBuilder;
import com.laptrinhjavaweb.entity.CustomerEntity;
import com.laptrinhjavaweb.paging.Pageable;

public interface ICustomerRepository extends JpaRepository<CustomerEntity>{
	List<CustomerEntity>findAll(Map<String, Object>params,Pageable pageable,CustomerSearchBuilder fieldsearch);
}
