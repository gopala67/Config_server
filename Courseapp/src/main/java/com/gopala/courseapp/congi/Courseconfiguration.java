package com.gopala.courseapp.congi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gopala.courseapp.repository.Courserepository;
import com.gopala.courseapp.service.Courseservice;
import com.gopala.courseapp.service.impl.Courseserviceimpl;
@Configuration
public class Courseconfiguration {
	
	@Bean
	Courseservice courseservice(Courserepository repo)
	{
		return new Courseserviceimpl(repo);
	}

}
