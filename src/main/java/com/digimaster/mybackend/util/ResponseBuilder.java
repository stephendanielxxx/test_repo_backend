package com.digimaster.mybackend.util;

import com.digimaster.mybackend.BaseResponse;

public class ResponseBuilder {
	
	public static <T> BaseResponse<T> setResponse(int code, boolean success, String message, T data){
		BaseResponse<T> baseResponse = new BaseResponse<>();
		baseResponse.setCode(code);
		baseResponse.setSuccess(success);
		baseResponse.setMessage(message);
		baseResponse.setData(data);
		
		return baseResponse;
	}
}
