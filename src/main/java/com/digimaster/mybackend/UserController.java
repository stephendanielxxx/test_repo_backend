package com.digimaster.mybackend;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	@GetMapping
	public List<UserResponseModel> getAllUser() {
		return userService.getAllUsers();
	}
	
	@GetMapping("/{name}")
	public UserDetailResponseModel getUserDetail(@PathVariable String name) {
		return userService.getUserDetail(name);
	}
	
	@GetMapping("/{name}/follower")
	public List<UserResponseModel> getUserFollower(@PathVariable String name){
		return userService.getUserFollower(name);
	}
}


