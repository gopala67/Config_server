package com.gopala.employeemanagement.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class Employeerequest {
	@NotNull(message = "name should not be null")
	private String name;
	@NotEmpty(message = "place should be entered")
	private String place;
	private Long employeeid;
	private String coursename;
	private String skillset;
	private int experience;
	 private Long employeeId;
	    private int month;
	    private int year;
	    private int daysPresent;
	
	

}
