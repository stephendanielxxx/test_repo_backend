package com.digimaster.mybackend.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel, Integer>{
	UserModel getUserModelByEmailAndPassword(String email, String password);
	UserModel getUserModelByEmail(String email);
}
