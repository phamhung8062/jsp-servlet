package com.laptrinhjavaweb.repository.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.laptrinhjavaweb.buider.BuildingSeachBuilder;
import com.laptrinhjavaweb.buider.UserSearchBuilder;
import com.laptrinhjavaweb.entity.UserEntity;
import com.laptrinhjavaweb.paging.Pageable;
import com.laptrinhjavaweb.repository.IUserRepository;

public class UserRepository extends SimpleJpaRepository<UserEntity> implements IUserRepository {

	@Override
	public List<UserEntity> findAll(Map<String, Object> params, Pageable pageable, UserSearchBuilder fieldsearch) {
		StringBuilder sqlSearch= new StringBuilder("SELECT * FROM user A ");
		if(StringUtils.isNotBlank(fieldsearch.getStaffId())) {
			sqlSearch.append(" INNER JOIN assignmentstaff  assignmentstaff ON A.id=assignmentstaff.staffid ");
		}
		sqlSearch.append(" WHERE 1=1 ");
		
		sqlSearch=this.CreateSQLfindAll(sqlSearch, params);
		String sqlSpecial= UserSqlSpecial(fieldsearch);
		sqlSearch.append(sqlSpecial);
		
		return this.findAll(sqlSearch.toString(), pageable);
	}

	private String UserSqlSpecial(UserSearchBuilder fieldSearch) {
		StringBuilder result=new StringBuilder("");
		if(StringUtils.isNotBlank(fieldSearch.getStaffId())) {
			result.append(" AND assignmentstaff.staffid ="+fieldSearch.getStaffId()+"");
		}
		return result.toString();
	}

	

}

