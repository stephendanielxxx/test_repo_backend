package com.digimaster.mybackend.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	public UserModel doLogin(String email, String password) {
		UserModel user = userRepository.getUserModelByEmailAndPassword(email, password);
		return user;
	}
	
	public UserModel doRegister(String email, String password) {
		UserModel exist = userRepository.getUserModelByEmail(email);
		if(exist != null) {
			return null;
		}else {
			UserModel newUser = new UserModel();
			newUser.setEmail(email);
			newUser.setPassword(password);
			return userRepository.save(newUser);
		}
	}
}
