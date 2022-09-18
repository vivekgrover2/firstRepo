package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.pojo.User;

@RestController
public class LoginController {

	
@GetMapping("/user")
User getUser() {
	return new User(1,"vivek","pass");
	
}
}
