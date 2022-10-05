package com.ashraf.blog.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ashraf.blog.payloads.ApiResponse;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse> resourceNotFoundExceptionHandler(ResourceNotFoundException ex){
		String messsage = ex.getMessage();
		ApiResponse apiResponse = new ApiResponse(messsage, false);
		return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handleMethodArgsNotValidException(MethodArgumentNotValidException ex){
		Map<String, String> resp= new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error)->{
			String fieldName =((FieldError)error).getField();
			String message = error.getDefaultMessage();
			resp.put(fieldName, message);
		});

		return new ResponseEntity<>(resp, HttpStatus.BAD_REQUEST);
	}

}
