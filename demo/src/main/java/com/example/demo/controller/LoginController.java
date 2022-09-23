package com.example.demo.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.pojo.User;

@RestController
public class LoginController {

	
@GetMapping("/user")
User getUser() {
	return new User(1,"vivek","pass");
	
}

@GetMapping("/users")
public ResponseEntity<User> usingResponseEntityBuilderAndHttpHeaders() {
    HttpHeaders responseHeaders = new HttpHeaders();
    responseHeaders.set("Access-Control-Allow-Origin", 
      "*");

    return ResponseEntity.ok()
      .headers(responseHeaders)
      .body(new User(1,"vivek","pass"));
}
}
