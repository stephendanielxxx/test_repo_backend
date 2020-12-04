package com.digimaster.mybackend;

import lombok.Data;

@Data
public class BaseResponse<T> {
	private int code;
	private boolean success;
	private String message;
	private T data;

}
