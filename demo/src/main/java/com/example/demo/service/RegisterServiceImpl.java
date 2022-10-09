package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.pojo.UserRegistration;
import com.example.demo.service.dao.RegisterDaoImpl;

@Service
public class RegisterServiceImpl {

	@Autowired
	RegisterDaoImpl registerDaoImpl;
	
	public void createUser(UserRegistration user) {
		registerDaoImpl.save(user);
	}
}
