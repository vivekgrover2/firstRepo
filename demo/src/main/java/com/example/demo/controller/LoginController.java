package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.pojo.User;
import com.example.demo.service.LoginServiceImpl;

@RestController
@RequestMapping("/users")
@CrossOrigin
public class LoginController {

	@Autowired
	LoginServiceImpl loginServiceImpl;
	/*
	 * @GetMapping("/user") User getUser() { return new User(1, "vivek", "pass");
	 * 
	 * }
	 */

	@GetMapping("/user")
	public ResponseEntity<User> usingResponseEntityBuilderAndHttpHeaders() {
		HttpHeaders responseHeaders = new HttpHeaders();
		//responseHeaders.set("Access-Control-Allow-Origin", "*");

		return ResponseEntity.ok().headers(responseHeaders).body(new User("1", "vivek", "pass"));
	}
	
	@PostMapping("/userpost")
	public ResponseEntity<User> userpost() {
		HttpHeaders responseHeaders = new HttpHeaders();
//		responseHeaders.set("Access-Control-Allow-Origin", "http://localhost:8080");
		//responseHeaders.set("Content-Type", "application/json");
		return ResponseEntity.ok().headers(responseHeaders).body(new User("1", "vivek", "pass"));
	}

	@PostMapping(path = "/createUser")
	public ResponseEntity<User> userLogin(@RequestBody User user) {
		
		System.out.println("inide : createUser----------------------------------- userName"+ user.getUserName()+ " ,password : " + user.getPassword());
		System.out.println("inide-----------------------------------");
		HttpHeaders responseHeaders = new HttpHeaders();
		
		responseHeaders.set("Access-Control-Allow-Credentials", "true");
		loginServiceImpl.createUser(user);
		return ResponseEntity.ok().headers(responseHeaders).body(new User("vivek", "passss"));
		/*
		 * if (userName.equals("nida")) { System.out.println("Valid User"); } else {
		 * System.out.println("Invalid User"); }
		 */

	}
	
	@PostMapping("/loginUser")
	public ResponseEntity<String> loginUser(@RequestBody User user) {
		HttpHeaders responseHeaders = new HttpHeaders();
		String responseMsg;
		if(loginServiceImpl.loginUser(user)) {
			responseMsg= "Login Successfull";;
		}
		else {
			 responseMsg= "Login Failed";
		}
		return ResponseEntity.ok().headers(responseHeaders).body(responseMsg);
	}
	 
}
