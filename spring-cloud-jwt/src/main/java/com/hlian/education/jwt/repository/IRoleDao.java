package com.hlian.education.jwt.repository;

import java.util.Set;

import org.springframework.data.repository.CrudRepository;

import com.hlian.education.jwt.entity.Role;

public interface IRoleDao extends CrudRepository<Role, Integer> {


	// @Transactional
	// @Modifying
	// @Query("update t_user t set t.username = :username where t.id = :id")
	// int updateUsernameById(@Param("username") String username, @Param("id")
	// int id);
	//
	// @Query("select t from t_user t ")
	// List<User> getList();

	Set<String> getByRolename(String rolename);
	
}