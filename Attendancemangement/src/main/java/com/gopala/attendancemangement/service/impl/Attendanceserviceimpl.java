package com.gopala.attendancemangement.service.impl;

import java.time.YearMonth;

import com.gopala.attendancemangement.dao.Attendancerepository;
import com.gopala.attendancemangement.entity.Attendanceentity;
import com.gopala.attendancemangement.model.Attendancerequest;
import com.gopala.attendancemangement.model.Attendancerespoonse;
import com.gopala.attendancemangement.service.Attendanceservice;

import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
public class Attendanceserviceimpl implements Attendanceservice {
	
	
	private final Attendancerepository attendancerepository;
	@Override
	public Attendancerespoonse  addattendancedetails(Attendancerequest request)
	{
		
		Attendancerespoonse response=new Attendancerespoonse();
		response.setEmployeeId(request.getEmployeeId());
		 int totalDaysInMonth = YearMonth.of(request.getYear(), request.getMonth()).lengthOfMonth();
		 double percentage = ((double) request.getDaysPresent() / totalDaysInMonth)*100;
		 response.setPercentage(percentage);
		
		
		Attendanceentity entity=new Attendanceentity();
		entity.setEmployeeId(request.getEmployeeId());
		entity.setMonth(request.getMonth());
		entity.setYear(request.getYear());
		entity.setDaysPresent(request.getDaysPresent());
		entity.setEmployeeId(request.getEmployeeId());
		entity.setPercentage(percentage);
		
		attendancerepository.save(entity);
		return response;
	}

}
