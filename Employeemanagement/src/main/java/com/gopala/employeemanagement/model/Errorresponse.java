package com.gopala.employeemanagement.model;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class Errorresponse {
	
	private String error;
	private String message;
	private HttpStatus httpstatuscode;

}
