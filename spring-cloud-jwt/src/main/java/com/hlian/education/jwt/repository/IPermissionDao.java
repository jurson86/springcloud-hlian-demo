package com.hlian.education.jwt.repository;

import java.util.Set;

import org.springframework.data.repository.CrudRepository;

import com.hlian.education.jwt.entity.Permission;

public interface IPermissionDao extends CrudRepository<Permission, Integer> {

	Set<String> getByPermissionname(String permissionname);

	// @Transactional
	// @Modifying
	// @Query("update t_user t set t.username = :username where t.id = :id")
	// int updateUsernameById(@Param("username") String username, @Param("id")
	// int id);
	//
	// @Query("select t from t_user t ")
	// List<User> getList();

}