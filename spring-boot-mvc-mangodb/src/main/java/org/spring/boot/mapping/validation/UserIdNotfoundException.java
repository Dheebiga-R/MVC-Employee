package org.spring.boot.mapping.validation;
//custom exception
public class UserIdNotfoundException extends Exception{

	public UserIdNotfoundException(String message) {
		super(message);
	}

}
