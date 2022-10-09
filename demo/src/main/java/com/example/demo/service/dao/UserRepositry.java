package com.example.demo.service.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.pojo.User;
public interface UserRepositry extends MongoRepository<User,String>{

	public User findByUserName(String userName);
	
}
