package com.example.demo.pojo;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor @NoArgsConstructor @Getter @Setter @EqualsAndHashCode @Document(collection = "user")
public class User implements Serializable{

	
	private static final long serialVersionUID = 1984895539906448961L;
	public User(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}
	@Id
	String id;
	String userName;
	String password;
}
