package com.chat.log.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="Message Not Found")
public class MessageNotFound extends RuntimeException {

	public MessageNotFound(String string) {
		super(string);
	}

	
}
