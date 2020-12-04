package com.digimaster.mybackend.jwt;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.digimaster.mybackend.user.UserModel;
import com.digimaster.mybackend.user.UserRepository;

@Service
public class JwtUserDetailsService implements UserDetailsService{
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		UserModel userModel = userRepository.getUserModelByEmail(email);
		if (userModel != null) {
			return new User(userModel.getEmail(), userModel.getPassword(),
					new ArrayList<>());
		} else {
			throw new UsernameNotFoundException("User not found with email: " +email);
		}
	}
	
	
}


