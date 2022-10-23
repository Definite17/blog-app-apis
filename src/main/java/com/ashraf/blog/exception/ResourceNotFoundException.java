package com.ashraf.blog.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResourceNotFoundException extends RuntimeException{
	
	String resourceName;
	String fieldName;
	Integer fieldValue;

	String userName;
	public ResourceNotFoundException(String resourceName, String fieldName, Integer fieldValue) {
		super(String.format("%s not found with %s:%d", resourceName, fieldName, fieldValue));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}

	public ResourceNotFoundException(String resourceName, String fieldName, String userName) {
		super(String.format("%s not found with %s:%s", resourceName, fieldName, userName));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.userName = userName;
	}

}
