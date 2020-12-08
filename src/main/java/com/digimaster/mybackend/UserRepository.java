package com.digimaster.mybackend;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface UserRepository {

	@GET("/users")
	Call<List<UserResponseModel>> getAllUser();
	
	@GET("/users/{name}")
	Call<UserDetailResponseModel> getUserDetail(@Path("name") String name);
	
	@GET("/users/{name}/followers")
	Call<List<UserResponseModel>> getUserFollower(@Path("name") String name);
}

