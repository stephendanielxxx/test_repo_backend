package com.digimaster.mybackend.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PasswordEncoder bcryptEncoder;
	
	public UserModel getUser(String email, String password) {
		UserModel user = userRepository.getUserModelByEmailAndPassword(email, bcryptEncoder.encode(password));
		return user;
	}
	
	public UserModel doRegister(String email, String password) {
		UserModel exist = userRepository.getUserModelByEmail(email);
		if(exist != null) {
			return null;
		}else {
			UserModel newUser = new UserModel();
			newUser.setEmail(email);
			newUser.setPassword(bcryptEncoder.encode(password));
			return userRepository.save(newUser);
		}
	}
}
