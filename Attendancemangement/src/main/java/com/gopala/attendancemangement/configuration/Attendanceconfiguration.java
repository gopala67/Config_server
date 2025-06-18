package com.gopala.attendancemangement.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gopala.attendancemangement.dao.Attendancerepository;
import com.gopala.attendancemangement.service.Attendanceservice;
import com.gopala.attendancemangement.service.impl.Attendanceserviceimpl;
@Configuration
public class Attendanceconfiguration {
	@Bean
	Attendanceservice attendanceservice(Attendancerepository repo)
	{
		return new Attendanceserviceimpl(repo);
	}

}
