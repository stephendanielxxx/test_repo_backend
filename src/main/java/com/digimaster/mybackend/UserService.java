package com.digimaster.mybackend;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Service
public class UserService {
	private static final String API_BASE_URL = "https://api.github.com";
	private UserRepository userRepository;
	private List<UserResponseModel> userResponseModels = new ArrayList<>();
	
	public UserService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        System.out.println("Initiate retrofit");
        userRepository = retrofit.create(UserRepository.class);
    }
	
	public List<UserResponseModel> getAllUsers(){
		try {
			Call<List<UserResponseModel>> call = userRepository.getAllUser();
			Response<List<UserResponseModel>> response = call.execute();
			return response.body();
		}catch (Exception e) {
			return null;
		}
		
	}
	
	public UserDetailResponseModel getUserDetail(String name) {
		try {
			Call<UserDetailResponseModel> call = userRepository.getUserDetail(name);
			Response<UserDetailResponseModel> response = call.execute();
			return response.body();
		}catch (Exception e) {
			return null;
		}
	}
	
	public List<UserResponseModel> getUserFollower(String name){
		try {
			Call<List<UserResponseModel>> call = userRepository.getUserFollower(name);
			
			call.enqueue(new Callback<List<UserResponseModel>>() {
				
				@Override
				public void onResponse(Call<List<UserResponseModel>> call, Response<List<UserResponseModel>> response) {
					// TODO Auto-generated method stub
					userResponseModels = response.body();
					System.out.println("on response");
				}
				
				@Override
				public void onFailure(Call<List<UserResponseModel>> call, Throwable t) {
					// TODO Auto-generated method stub
					userResponseModels = new ArrayList<>();
					System.out.println("on failure");
				}
			});
			return userResponseModels;
		}catch (Exception e) {
			return null;
		}
	}
}


