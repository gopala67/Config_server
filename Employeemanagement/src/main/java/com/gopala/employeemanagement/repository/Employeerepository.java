package com.gopala.employeemanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gopala.employeemanagement.entity.Employeedetails;
@Repository
public interface Employeerepository  extends JpaRepository<Employeedetails, Long>{
	
	
List<Employeedetails> findByName(String name);

List<Employeedetails>  findByNameAndPlace(String name,String place);

List<Employeedetails>   findByNameOrPlace(String name,String place);



}
