package com.digimaster.mybackend.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.digimaster.mybackend.BaseResponse;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/login")
	public BaseResponse<UserModel> login(@RequestParam String email, @RequestParam String password) {
		BaseResponse<UserModel> baseResponse = new BaseResponse<>();
		UserModel user = userService.doLogin(email, password);
		
		if(user != null) {
			baseResponse.setCode(200);
			baseResponse.setSuccess(true);
			baseResponse.setMessage("Login Success");
			baseResponse.setData(user);
		}else {
			baseResponse.setCode(400);
			baseResponse.setSuccess(false);
			baseResponse.setMessage("Login Failed");
			baseResponse.setData(user);
		}
		
		return baseResponse;
	}
	
	@PostMapping("/register")
	public BaseResponse<UserModel> register(@RequestParam String email, @RequestParam String password) {
		BaseResponse<UserModel> baseResponse = new BaseResponse<>();
		UserModel user = userService.doRegister(email, password);
		
		if(user != null) {
			baseResponse.setCode(200);
			baseResponse.setSuccess(true);
			baseResponse.setMessage("Success register");
			baseResponse.setData(user);
		}else {
			baseResponse.setCode(400);
			baseResponse.setSuccess(false);
			baseResponse.setMessage("failed register");
			baseResponse.setData(user);
		}
		
		return baseResponse;
	}
}
