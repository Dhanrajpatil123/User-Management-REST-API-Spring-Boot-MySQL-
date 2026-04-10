package com.dhanraj.dto;
 
import lombok.Getter; 
import lombok.Setter;

@Getter
@Setter 
public class UserResponseDTO {

	private int id;
	
	private String name;
	
	private String email;
	
	private String password;
	
	private String status;
	
	private String category;
}
