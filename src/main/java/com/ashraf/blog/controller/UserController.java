package com.ashraf.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ashraf.blog.payloads.ApiResponse;
import com.ashraf.blog.payloads.UserDto;
import com.ashraf.blog.service.UserService;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	//POST-create user
	@PostMapping("/")
	public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto) {
		UserDto createUserDto = this.userService.createUSer(userDto);
		
		return new ResponseEntity<>(createUserDto, HttpStatus.CREATED);
	}
	
	//PUT- update user
	@PutMapping("/{userId}")
	public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto, @PathVariable("userId") Integer uid){
		UserDto updatedUserDto = new UserDto();

		updatedUserDto = this.userService.updateUser(userDto, uid);
		
		return ResponseEntity.ok(updatedUserDto);
	}
	
	// DELETE- delete user
	@DeleteMapping("/{userId}")
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable Integer userId){
		this.userService.deleteUser(userId);
		
		// return ResponseEntity.ok(Map.of("message", "user deleted successfully"));
		
		// OR
		
		return new ResponseEntity<>(new ApiResponse("USer Deleted Successfully", true), HttpStatus.OK);
	} 
	
	//GET-get user
	@GetMapping("/")
	public ResponseEntity<List<UserDto>> getAllUsers(){
		return ResponseEntity.ok(this.userService.getAllUsers());
	}
	
	//GET-get user
	@GetMapping("/{userId}")
	public ResponseEntity<UserDto> getUserById(@PathVariable Integer userId){
		return ResponseEntity.ok(this.userService.getUserById(userId));
	}
}
