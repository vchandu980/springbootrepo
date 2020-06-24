package com.SpringBootFirstSpringBootWebService.SpringBootWebService.exception;


import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.SpringBootFirstSpringBootWebService.SpringBootWebService.user.InvalidPostDetailsException;
import com.SpringBootFirstSpringBootWebService.SpringBootWebService.user.InvalidUserDetailsException;
import com.SpringBootFirstSpringBootWebService.SpringBootWebService.user.UserNotFoundException;


@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request){
		ExceptionResponse exceptionresponse = new ExceptionResponse(new Date(),ex.getMessage(),request.getDescription(false));
		
		return new ResponseEntity(exceptionresponse,HttpStatus.INTERNAL_SERVER_ERROR);
	
	

}
	
	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<Object> handleUserNotFoundException(Exception ex, WebRequest request){
		ExceptionResponse exceptionresponse = new ExceptionResponse(new Date(),ex.getMessage(),request.getDescription(false));
		
		return new ResponseEntity(exceptionresponse,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(InvalidUserDetailsException.class)
	public final ResponseEntity<Object> handleInvalidUserDetailsException(Exception ex, WebRequest request){
		ExceptionResponse exceptionresponse = new ExceptionResponse(new Date(),ex.getMessage(),request.getDescription(false));
			
		return new ResponseEntity(exceptionresponse,HttpStatus.BAD_REQUEST);

}
	
	@ExceptionHandler(InvalidPostDetailsException.class)
	public final ResponseEntity<Object> handleInvalidPostDetailsException(Exception ex, WebRequest request){
		ExceptionResponse exceptionresponse = new ExceptionResponse(new Date(),ex.getMessage(),request.getDescription(false));
			
		return new ResponseEntity(exceptionresponse,HttpStatus.BAD_REQUEST);

}
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		ExceptionResponse exceptionresponse = new ExceptionResponse(new Date(),"Validation Failed",ex.getBindingResult().getAllErrors().toString());
		
		return new ResponseEntity(exceptionresponse,HttpStatus.BAD_REQUEST);
	}
} 
