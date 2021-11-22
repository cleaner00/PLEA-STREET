package com.plestreet.community.exception;

public class UserAlreadyExistException extends RuntimeException{
	public UserAlreadyExistException() {

	}
	public UserAlreadyExistException(String message) {
		super(message);
	}
	public UserAlreadyExistException(String message, Throwable cause) {
		super(message, cause);
	}
}
