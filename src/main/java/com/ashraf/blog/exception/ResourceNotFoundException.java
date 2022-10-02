package com.ashraf.blog.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResourceNotFoundException extends RuntimeException{
	
	String resourName;
	String fieldName;
	Integer fieldValue;
	public ResourceNotFoundException(String resourName, String fieldName, Integer fieldValue) {
		super(String.format("%s not found with %s:%d", resourName, fieldName, fieldValue));
		this.resourName = resourName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}
	
	

}
