package com.example.demo.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.pojo.User;

@RestController
@RequestMapping("/users")
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
	public ResponseEntity<User> userLogin(@RequestParam String userName, @RequestParam String password) {
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("Content-Type", "application/json; charset=utf8");
		
		responseHeaders.set("Access-Control-Allow-Origin", "*");
		responseHeaders.set("Access-Control-Allow-Credentials", "true");
		responseHeaders.set("Access-Control-Allow-Methods", "GET,HEAD,OPTIONS,POST,PUT");
		responseHeaders.set("Access-Control-Allow-Headers", "Access-Control-Allow-Headers, Origin,Accept, X-Requested-With, Content-Type, Access-Control-Request-Method, Access-Control-Request-Headers");
		
		System.out.println(userName); // return ResponseEntity.ok();
		return ResponseEntity.ok().headers(responseHeaders).body(new User(1, "vivek", "pass"));
		/*
		 * if (userName.equals("nida")) { System.out.println("Valid User"); } else {
		 * System.out.println("Invalid User"); }
		 */

	}
	 
}
