package com.gopala.employeemanagement.service;

import java.util.List;

import com.gopala.employeemanagement.dto.Employeedto;
import com.gopala.employeemanagement.entity.Employeedetails;
import com.gopala.employeemanagement.model.Courserequest;
import com.gopala.employeemanagement.model.Employeerequest;

public interface Employeeservice {

	Employeerequest addetails(Employeerequest request);

	Employeedto getdetailsbyid(Long id);

	List<Employeedetails> findByName(String name);

	List<Employeedetails> findByNameAndPlace(String name, String place);

	List<Employeedetails> findByNameOrPlace(String name, String place);

	//String getdetails();
	
	//public void addetails();

}
