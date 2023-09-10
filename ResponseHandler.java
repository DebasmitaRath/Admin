package com.boot.aatral.response;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseHandler {

	public static ResponseEntity<Object> responseBuilder(String message, HttpStatus httpStatus, Object responseObject) {
		Map<String, Object> response = new HashMap<>();
		response.put("message", message);
		response.put("httpStatus", httpStatus);
		response.put("data", responseObject);

		return new ResponseEntity<Object>(response, httpStatus);
	}
}
