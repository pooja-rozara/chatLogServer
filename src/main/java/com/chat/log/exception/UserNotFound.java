package com.chat.log.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="User Not Found")
public class UserNotFound extends RuntimeException {

	public UserNotFound(String string) {
		super(string);
	}
	
	

}
