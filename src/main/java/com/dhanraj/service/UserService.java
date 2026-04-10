package com.dhanraj.service;

import java.util.List;

import com.dhanraj.dto.LoginRequest;
import com.dhanraj.dto.RegisterRequest;
import com.dhanraj.dto.UserResponseDTO;

public interface UserService {

	UserResponseDTO userLogin(LoginRequest loginRequest);
	
	UserResponseDTO userRegister(RegisterRequest registerRequest);
	
	List<UserResponseDTO> getAllUsers();
	
	UserResponseDTO getUserById(int userId);
	
	void deleteUser(int userId);
	
	UserResponseDTO updateUser(int userId, RegisterRequest registerRequest);
	
	List<String> getNameByCategory(String category); 
	
}
