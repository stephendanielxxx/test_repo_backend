package com.digimaster.mybackend.person;

public class PersonsResponse<T> {
	private int code;
	private boolean success;
	private String message;
	private Iterable<T> data;
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Iterable<T> getData() {
		return data;
	}
	public void setData(Iterable<T> data) {
		this.data = data;
	}
	

}
