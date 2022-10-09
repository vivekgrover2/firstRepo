package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.pojo.User;
import com.example.demo.service.dao.UserRepositry;

@Service
public class RegisterServiceImpl {

	@Autowired
	UserRepositry userRepositry;
	
	public void createUser(User user) {
		userRepositry.save(user);
	}
}
