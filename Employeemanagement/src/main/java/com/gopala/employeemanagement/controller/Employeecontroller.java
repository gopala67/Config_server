package com.gopala.employeemanagement.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gopala.employeemanagement.dto.Employeedto;
import com.gopala.employeemanagement.entity.Employeedetails;
import com.gopala.employeemanagement.model.Courserequest;
import com.gopala.employeemanagement.model.Employeerequest;
import com.gopala.employeemanagement.service.Employeeservice;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employee")
public class Employeecontroller {
	
	private final Employeeservice employeeservice;
	@PostMapping("/add")
	public Employeerequest addetails(@RequestBody Employeerequest request)
	{
	return	employeeservice.addetails(request);
	}
	@GetMapping("/get/{id}")
	 public Employeedto getdetailsbyid(@PathVariable  Long id)
	 {
	return	 employeeservice.getdetailsbyid(id);
	 }
	@GetMapping("/fetch/{name}")
	public List<Employeedetails> findByName(@PathVariable String  name)
	{
	return	employeeservice.findByName(name);
	}
	@GetMapping("all/{name}/{place}")
	public List<Employeedetails>  findByNameAndPlace(@PathVariable  String name,@PathVariable   String place){
		return employeeservice.findByNameAndPlace(name, place);
	}
	
	@GetMapping("/need/{name}/{place}")
	 public List<Employeedetails> findByNameOrPlace(@PathVariable  String name,@PathVariable   String place)
	 {
	return	employeeservice.findByNameOrPlace(name, place); 
	 }
//	@GetMapping("/dummy")
//	public String getdetails()
//	{
//	return	employeeservice.getdetails();
//	}
	
	

}
