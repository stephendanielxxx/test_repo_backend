package com.digimaster.mybackend.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.digimaster.mybackend.BaseResponse;
import com.digimaster.mybackend.jwt.JwtResponse;
import com.digimaster.mybackend.jwt.JwtTokenUtil;
import com.digimaster.mybackend.jwt.JwtUserDetailsService;
import com.digimaster.mybackend.util.ResponseBuilder;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtUserDetailsService userDetailsService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@PostMapping("/login")
	public BaseResponse<JwtResponse> login(@RequestParam String email, @RequestParam String password) {		
		try {
			authenticate(email, password);
			UserDetails userDetails = userDetailsService.loadUserByUsername(email);
			String token = jwtTokenUtil.generateToken(userDetails);
			
			return ResponseBuilder.setResponse(200, true, "Login Success", new JwtResponse(token));
			
		}catch (Exception e) {
			return ResponseBuilder.setResponse(400, false, "Login Failed", null);
		}
	
	}
	
	@PostMapping("/register")
	public BaseResponse<UserModel> register(@RequestParam String email, @RequestParam String password) {
		BaseResponse<UserModel> baseResponse = new BaseResponse<>();
		UserModel user = userService.doRegister(email, password);
		
		if(user != null) {
			return ResponseBuilder.setResponse(200, true, "Success register", user);
			
		}else {
			
			return ResponseBuilder.setResponse(400, false, "Failed register", user);
		}
		
	}
	
	private void authenticate(String username, String password) throws Exception{
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (AuthenticationException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
}
