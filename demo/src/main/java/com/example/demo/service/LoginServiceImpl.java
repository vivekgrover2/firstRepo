package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.pojo.User;
import com.example.demo.service.dao.LoginDaoImpl;

@Service
public class LoginServiceImpl {
	Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);

	@Autowired
	LoginDaoImpl loginDaoImpl;

	public boolean loginUser(User user) {
		logger.info("Inside LoginServiceImpl.loginUser" + user.getId());
		System.out.println("Insideeee LoginServiceImpl.loginUser : " + user.getId());
		Optional<User> savedUser = loginDaoImpl.findById(user.getId());
		List<User> Users= loginDaoImpl.findAll();
		System.out.println("Users.size(): "+ Users.size());
		// return savedUser.ifPresentOrElse(user -> comparePassword(password, user), ()
		// -> System.out.println("user Not Found"));
		if (savedUser.isPresent()) {
			return comparePassword(user.getPassword(), savedUser.get());
		}
		else {
			System.out.println("get failed" + user);	
		// savedUser = loginDaoImpl.findAById(user.getId());
		}

		return false;
	}

	private boolean comparePassword(String password, User user) {
		System.out.println("Insideeee LcomparePassword" + user.getId());
		return user.getPassword().equals(password);
	}
	
	public void createUser(User user) {
		logger.info("Inside createUser.loginUser" + user);
		loginDaoImpl.save(user);
	}

}
