package com.hlian.education.jwt.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.hlian.education.jwt.entity.User;

public interface IUserDao extends CrudRepository<User, Integer> {

	// @Transactional
	// @Modifying
	// @Query("update t_user t set t.username = :username where t.id = :id")
	// int updateUsernameById(@Param("username") String username, @Param("id")
	// int id);
	//
	// @Query("select t from t_user t ")
	// List<User> getList();
	
	User getByUsername(String username);


}