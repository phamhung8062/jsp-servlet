package com.laptrinhjavaweb.repository;

import java.util.List;
import java.util.Map;

import com.laptrinhjavaweb.buider.UserSearchBuilder;
import com.laptrinhjavaweb.entity.UserEntity;
import com.laptrinhjavaweb.paging.Pageable;

public interface IUserRepository extends JpaRepository<UserEntity>{
	List<UserEntity>findAll(Map<String, Object>params,Pageable pageable,UserSearchBuilder fieldsearch);
}
