package com.dhanraj.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id; 
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "userId")
	private int id;
	
	
	@Column(name = "userName", nullable = false)
	private String name;
	
	
	@Column(name = "userEmail", nullable = false)
	private String email;
	
	
	@Column(name = "userPassword", nullable = false)
	private String password;
	
	@Column(name = "user_status", nullable = false)
	private String status;
	
	@Column(name = "category", nullable = false)
	private String category;
	
}
