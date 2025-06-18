package com.gopala.courseapp.service.impl;

import com.gopala.courseapp.entity.Coursedetails;
import com.gopala.courseapp.model.Courserequest;
import com.gopala.courseapp.repository.Courserepository;
import com.gopala.courseapp.service.Courseservice;

import lombok.AllArgsConstructor;
@AllArgsConstructor
public class Courseserviceimpl  implements Courseservice{
	
	private final Courserepository courserepository;
	
	
	@Override
	public Coursedetails addcoursedetails(Courserequest request)
	{
		Coursedetails coursedetails=new Coursedetails();
		coursedetails.setEmployeeid(request.getEmployeeid());
		coursedetails.setCoursename(request.getCoursename());
		coursedetails.setSkillset(request.getSkillset());
		coursedetails.setExperience(request.getExperience());
		return courserepository.save(coursedetails);
	}

}
