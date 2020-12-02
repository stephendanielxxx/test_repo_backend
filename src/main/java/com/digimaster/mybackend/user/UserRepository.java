package com.digimaster.mybackend.user;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserModel, Integer>{
	UserModel getUserModelByEmailAndPassword(String email, String password);
	UserModel getUserModelByEmail(String email);
}
