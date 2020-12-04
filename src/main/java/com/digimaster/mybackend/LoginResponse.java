package com.digimaster.mybackend;
public class LoginResponse<T> extends BaseResponse<T>{
	private String token;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}
