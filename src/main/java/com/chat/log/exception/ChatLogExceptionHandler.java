package com.chat.log.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ChatLogExceptionHandler {

	@ExceptionHandler({UserNotFound.class,MessageNotFound.class})
	public ResponseEntity<ApiError> handleException(Exception e) {
		ApiError err= new ApiError();
		err.setMessage(e.getLocalizedMessage());
		err.setStatus(HttpStatus.NOT_FOUND);
		return new ResponseEntity<ApiError>(err, err.getStatus());
	}
	
	@ExceptionHandler
	public ResponseEntity<ApiError> handleOtherException(Exception e) {
		ApiError err= new ApiError();
		err.setMessage(e.getLocalizedMessage());
		err.setStatus(HttpStatus.BAD_REQUEST);
		return new ResponseEntity<ApiError>(err, err.getStatus());
	}
}
