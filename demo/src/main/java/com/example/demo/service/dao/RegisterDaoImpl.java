package com.example.demo.service.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.pojo.UserRegistration;

public interface RegisterDaoImpl extends MongoRepository<UserRegistration,String>{

}
