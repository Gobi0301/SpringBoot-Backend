package com.example.springbootRest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{

	public ResourceNotFoundException(String resourceName, String filedName, Object filedValue) {
		super(String.format("%s is not found with %s:'%S'", resourceName,filedName,filedValue));
		this.resourceName = resourceName;
		this.filedName = filedName;
		this.filedValue = filedValue;
	}
	private String resourceName;
	private String filedName;
	private Object filedValue;
	
	
	public String getResourceName() {
		return resourceName;
	}
	public String getFiledName() {
		return filedName;
	}
	public Object getFiledValue() {
		return filedValue;
	}
}
