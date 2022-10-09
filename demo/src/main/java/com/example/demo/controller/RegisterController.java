package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.pojo.User;
import com.example.demo.service.RegisterServiceImpl;

@RestController
@RequestMapping("/registerUser")
@CrossOrigin
public class RegisterController {
	
	@Autowired
	RegisterServiceImpl registerServiceImpl;

	/*
	 * @GetMapping("/getRegisteredUser") public ResponseEntity<User>
	 * getRegisteredUser() { HttpHeaders responseHeaders = new HttpHeaders(); return
	 * ResponseEntity.ok().headers(responseHeaders).body(new User("1",
	 * "vivek","abc", "pass")); }
	 */

	@PostMapping(path = "/create")
	public ResponseEntity<User> registerUser(@RequestBody User usrRegister) {
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("Content-Type", "application/json");
		responseHeaders.set("Accept", "application/json");
		responseHeaders.set("Access-Control-Allow-Credentials", "true");
		registerServiceImpl.createUser(usrRegister);
		return ResponseEntity.ok().headers(responseHeaders).body(usrRegister);
	}

}
