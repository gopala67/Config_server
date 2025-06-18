package com.gopala.courseapp.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gopala.courseapp.entity.Coursedetails;
import com.gopala.courseapp.model.Courserequest;
import com.gopala.courseapp.service.Courseservice;

import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@RestController
@RequestMapping("/course")
public class Coursecontroller {
	
	
	private final Courseservice courseservice;
	@PostMapping("/posts")
	public Coursedetails addcoursedetails(@RequestBody  Courserequest request) throws InterruptedException
	{
		Thread.sleep(10000);
		return courseservice.addcoursedetails(request);
	}

}
