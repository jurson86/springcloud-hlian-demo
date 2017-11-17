package com.hlian.education.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hlian.education.util.JSONResult;

@RestController
class UserController {

	// 路由映射到/users
	@RequestMapping(value = "/token", produces = "application/json;charset=UTF-8")
	public String usersList() {

		ArrayList<String> users = new ArrayList<String>() {
			{
				add("OK");
			}
		};

		return JSONResult.fillResultString(0, "", users);
	}

	@RequestMapping(value = "/hello", produces = "application/json;charset=UTF-8")
	public String hello() {
		ArrayList<String> users = new ArrayList<String>() {
			{
				add("hello");
			}
		};
		return JSONResult.fillResultString(0, "", users);
	}

	@RequestMapping(value = "/world", produces = "application/json;charset=UTF-8")
	public String world() {
		ArrayList<String> users = new ArrayList<String>() {
			{
				add("world");
			}
		};
		return JSONResult.fillResultString(0, "", users);
	}

}