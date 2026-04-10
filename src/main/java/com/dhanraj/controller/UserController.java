package com.dhanraj.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dhanraj.dto.LoginRequest;
import com.dhanraj.dto.RegisterRequest;
import com.dhanraj.dto.UserResponseDTO;
import com.dhanraj.model.User;
import com.dhanraj.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {

	private final UserService userService;
	
	
	@PostMapping("/register")
	public ResponseEntity<?> userRegister(@RequestBody RegisterRequest registerRequest){
		
		try {
			UserResponseDTO userResponseDTO = this.userService.userRegister(registerRequest);
			return ResponseEntity.status(HttpStatus.CREATED).body(userResponseDTO);
		}
		catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	
	@PostMapping("/login")
	public ResponseEntity<?> userLogin(@RequestBody LoginRequest loginRequest){
		
		try {
			UserResponseDTO user = this.userService.userLogin(loginRequest);
			return ResponseEntity.status(HttpStatus.ACCEPTED).body("Login Successfully");
		}
		catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
	
	@GetMapping("/allUsers")
	public ResponseEntity<?> getAllUsers(){
		
		try {
			List<UserResponseDTO> users = this.userService.getAllUsers();
			return ResponseEntity.ok(users);
		}
		catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}
	
	
	@GetMapping("/{userId}")
	public ResponseEntity<?> getUserId(@PathVariable int userId){
		
		try {
			return ResponseEntity.ok(this.userService.getUserById(userId));
		}
		catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}
	
	
	@DeleteMapping("/{userId}")
	public ResponseEntity<?> deleteUser(@PathVariable int userId){
		
		try {
			this.userService.deleteUser(userId);
			return ResponseEntity.noContent().build();
		}
		catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(e.getMessage());
		}
	}
	
	
	@PutMapping("/updateUser/{userId}")
	public ResponseEntity<?> updateUser(@PathVariable int userId, @RequestBody RegisterRequest registerRequest){
		
		try {
			
			UserResponseDTO user = this.userService.updateUser(userId, registerRequest);
			return ResponseEntity.status(HttpStatus.CREATED).body(user);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	
	
	@GetMapping("/category/{category}")
	public ResponseEntity<?> getNameByCategory(@PathVariable String category) {

	    try {
	        List<String> names = userService.getNameByCategory(category);

	        if (names.isEmpty()) {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND)
	                    .body("No users found for category: " + category);
	        }

	        return ResponseEntity.ok(names);

	    } catch (Exception e) {
	        return ResponseEntity.badRequest().body(e.getMessage());
	    }
	}
	
}
