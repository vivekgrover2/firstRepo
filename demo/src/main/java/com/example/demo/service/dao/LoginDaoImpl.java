package com.example.demo.service.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.pojo.User;
public interface LoginDaoImpl extends MongoRepository<User,String>{

	
}
