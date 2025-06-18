package com.gopala.attendancemangement.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gopala.attendancemangement.model.Attendancerequest;
import com.gopala.attendancemangement.model.Attendancerespoonse;
import com.gopala.attendancemangement.service.Attendanceservice;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/attendance")
public class Attendancecontroller {
	
	
	private final Attendanceservice attendanceservice;
	@PostMapping("/add")
	public Attendancerespoonse aaddattendancedetails(@RequestBody Attendancerequest request) throws InterruptedException
	{
		
		Thread.sleep(10000);
	return	attendanceservice.addattendancedetails(request);
	}

}
