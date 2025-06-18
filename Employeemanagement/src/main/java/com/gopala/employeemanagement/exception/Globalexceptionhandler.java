package com.gopala.employeemanagement.exception;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.gopala.employeemanagement.model.Errorresponse;

@RestControllerAdvice
public class Globalexceptionhandler {
	
	@ExceptionHandler(ConstraintViolationException.class)
	public Errorresponse constrainviolationhandler(ConstraintViolationException ex)
	{
		Errorresponse response=new Errorresponse();
		response.setError("error while persisiting the data");
		response.setMessage(ex.getMessage());
		response.setHttpstatuscode(HttpStatus.BAD_REQUEST);
		return response;
	}
	@ExceptionHandler(Exception.class)
	public Errorresponse exception(Exception ex)
	{
		Errorresponse response=new Errorresponse();
		response.setError("error while persisiting the data");
		response.setMessage(ex.getMessage());
		response.setHttpstatuscode(HttpStatus.BAD_REQUEST);
		return response;
	}

}
