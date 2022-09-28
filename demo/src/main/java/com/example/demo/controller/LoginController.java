package com.example.demo.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.pojo.User;

@RestController
@RequestMapping("/myshopping")
@CrossOrigin
public class LoginController {

	/*
	 * @GetMapping("/user") User getUser() { return new User(1, "vivek", "pass");
	 * 
	 * }
	 */

	@GetMapping("/user")
	public ResponseEntity<User> usingResponseEntityBuilderAndHttpHeaders() {
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("Access-Control-Allow-Origin", "*");

		return ResponseEntity.ok().headers(responseHeaders).body(new User(1, "vivek", "pass"));
	}

	@PostMapping(path = "/createUser")
	public ResponseEntity<User> userLogin(@RequestBody User user) {
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("Content-Type", "application/json");
		responseHeaders.set("Accept", "application/json");
		return ResponseEntity.ok().headers(responseHeaders).body(user);
	}
}
