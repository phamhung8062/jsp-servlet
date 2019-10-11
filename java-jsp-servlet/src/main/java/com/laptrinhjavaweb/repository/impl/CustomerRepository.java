package com.laptrinhjavaweb.repository.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.laptrinhjavaweb.buider.BuildingSeachBuilder;
import com.laptrinhjavaweb.buider.CustomerSearchBuilder;
import com.laptrinhjavaweb.buider.UserSearchBuilder;
import com.laptrinhjavaweb.entity.CustomerEntity;
import com.laptrinhjavaweb.entity.UserEntity;
import com.laptrinhjavaweb.paging.Pageable;
import com.laptrinhjavaweb.repository.ICustomerRepository;
import com.laptrinhjavaweb.repository.IUserRepository;

public class CustomerRepository extends SimpleJpaRepository<CustomerEntity> implements ICustomerRepository {

	

	

	@Override
	public List<CustomerEntity> findAll(Map<String, Object> params, Pageable pageable,
			CustomerSearchBuilder fieldsearch) {
		StringBuilder sqlSearch= new StringBuilder("SELECT * FROM customer A ");
		if(StringUtils.isNotBlank(fieldsearch.getStaffId())) {
			sqlSearch.append(" INNER JOIN assignmentstaff  assignmentstaff ON A.id=assignmentstaff.customerid ");
		}
		sqlSearch.append(" WHERE 1=1 ");
		
		sqlSearch=this.CreateSQLfindAll(sqlSearch, params);
		String sqlSpecial= CustomerSqlSpecial(fieldsearch);
		sqlSearch.append(sqlSpecial);
		
		return this.findAll(sqlSearch.toString(), pageable);
	}
	private String CustomerSqlSpecial( CustomerSearchBuilder fieldSearch) {
		StringBuilder result=new StringBuilder("");
		if(StringUtils.isNotBlank(fieldSearch.getStaffId())) {
			result.append(" AND assignmentstaff.staffid ="+fieldSearch.getStaffId()+"");
		}
		return result.toString();
	}

	

}

