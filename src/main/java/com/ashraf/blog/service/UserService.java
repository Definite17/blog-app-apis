package com.ashraf.blog.service;

import java.util.List;
import com.ashraf.blog.payloads.UserDto;

public interface UserService {

	UserDto registerNewUser(UserDto userDto);

	UserDto createUSer(UserDto userDto);
	
	UserDto updateUser(UserDto userDto, Integer userId);
	
	UserDto getUserById(Integer userId);
	
	List<UserDto> getAllUsers();
	
	void deleteUser(Integer userId);
}
