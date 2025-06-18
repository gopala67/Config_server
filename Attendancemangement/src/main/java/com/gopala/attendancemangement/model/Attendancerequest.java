package com.gopala.attendancemangement.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Attendancerequest {
	
	 private Long employeeId;
	    private int month;
	    private int year;
	    private int daysPresent;

}
