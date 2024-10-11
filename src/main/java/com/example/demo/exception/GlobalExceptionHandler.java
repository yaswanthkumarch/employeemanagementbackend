package com.example.demo.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;


@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<Object> handleResouceNotFoundException(ResourceNotFoundException e,WebRequest request){
		Map<String, Object> responseBody=new HashMap<>();
		responseBody.put("timestamp", LocalDateTime.now());
		responseBody.put("message", e.getMessage());
		responseBody.put("details", request.getDescription(false));
		
		return new ResponseEntity<>(responseBody, HttpStatus.NOT_FOUND);
	}
}
