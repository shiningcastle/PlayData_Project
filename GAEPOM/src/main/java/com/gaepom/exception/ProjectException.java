package com.gaepom.exception;

public class ProjectException extends RuntimeException {
	public ProjectException () {}
	
	public ProjectException(String message) {
		super(message);
	}
}

