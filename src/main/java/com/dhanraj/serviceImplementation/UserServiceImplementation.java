package com.dhanraj.serviceImplementation;

import java.util.List; 

import org.springframework.stereotype.Service;

import com.dhanraj.dto.LoginRequest;
import com.dhanraj.dto.RegisterRequest;
import com.dhanraj.dto.UserResponseDTO;
import com.dhanraj.model.User;
import com.dhanraj.repository.UserRepository;
import com.dhanraj.service.UserService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserServiceImplementation implements UserService{
	
	private final UserRepository userRepository;
	

	@Override
	public UserResponseDTO userLogin(LoginRequest loginRequest) {
		
		User user = this.userRepository.findByEmail(loginRequest.getEmail())
				.orElseThrow(() -> new RuntimeException("User not found"));
		
		if(! user.getPassword().equals(loginRequest.getPassword()))
			throw new RuntimeException("Invalid Password");
		
		
		return mapToDTO(user);
	}
 
	
	@Override
	public UserResponseDTO userRegister(RegisterRequest registerRequest) {
		
		if(this.userRepository.findByEmail(registerRequest.getEmail()).isPresent()) {
			
			throw new RuntimeException("Email already exists...");
		}
		User user = mapToEntity(registerRequest);
		
		// save
		User savedUser = this.userRepository.save(user);
		
		return mapToDTO(savedUser);
	}
	
	
	// DTO to Entity
	private User mapToEntity(RegisterRequest registerRequest) {
		
		User user = new User();
		user.setEmail(registerRequest.getEmail());
		user.setName(registerRequest.getName());
		user.setPassword(registerRequest.getPassword());
		user.setCategory(registerRequest.getCategory());
		user.setStatus("ACTIVE");
		
		return user;
	}
	
	// entity to DTO
	private UserResponseDTO mapToDTO(User user) {
		
		UserResponseDTO userDto = new UserResponseDTO();
		userDto.setId(user.getId());
		userDto.setName(user.getName());
		userDto.setEmail(user.getEmail());
		userDto.setStatus(user.getStatus());
		userDto.setCategory(user.getCategory());
		
		return userDto;
	}


	@Override
	public List<UserResponseDTO> getAllUsers() {
		
		List<User> users = this.userRepository.findAll();
		
		return users.stream()
				.map(this::mapToDTO)
				.toList();
	}


	@Override
	public UserResponseDTO getUserById(int userId) {
		
		User user = this.userRepository.findById(userId)
				.orElseThrow(() -> new RuntimeException("User not found with id " + userId));
		
		return mapToDTO(user);
	}


	@Override
	public void deleteUser(int userId) {
		
		User user = this.userRepository.findById(userId)
				.orElseThrow(() -> new RuntimeException("User not found with id " + userId));
		
		this.userRepository.delete(user);
	}


	@Override
	public UserResponseDTO updateUser(int userId, RegisterRequest registerRequest) {
		
		User user = this.userRepository.findById(userId)
				.orElseThrow(() -> new RuntimeException("User not found with id " + userId));
		
		user.setName(registerRequest.getName());
		user.setEmail(registerRequest.getEmail());
		user.setPassword(registerRequest.getPassword());
		user.setCategory(registerRequest.getCategory());
		user.setStatus(registerRequest.getStatus());
		
		User updateUser = this.userRepository.save(user);
		
		return mapToDTO(updateUser);
	}


	@Override
	public List<String> getNameByCategory(String category) {
		
		List<User> users = userRepository.findByCategoryIgnoreCase(category);
		
		return users.stream()
				.map(User::getName)
				.toList(); 
		
	}
	

}
 