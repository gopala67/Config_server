package com.gopala.employeemanagement.confi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.gopala.employeemanagement.Httpclient;
import com.gopala.employeemanagement.async.Courseasync;
import com.gopala.employeemanagement.feign.Attendancefeignclient;
import com.gopala.employeemanagement.feign.Coursefeignclient;
import com.gopala.employeemanagement.repository.Employeerepository;
import com.gopala.employeemanagement.service.Employeeservice;
import com.gopala.employeemanagement.service.impl.Employeeserviceimpl;
@Configuration
public class Employeeconfigurations {
	
	@Bean
	public Employeeservice employeeservice(Employeerepository repo, Httpclient client, Coursefeignclient feign,Attendancefeignclient atte,Courseasync ass,Redisemployeecache redis) {
	    return new Employeeserviceimpl(repo, client, feign,atte,ass,redis);
	}

	//
//	Employeerepository repo()
//	{
//		return new Employee
//	}
	@Bean
	RestTemplate restTemplate()
	{
		return new RestTemplate();
	}
	@Bean
	Httpclient httpclient() {
		return new Httpclient();
	}
	@Bean
	Courseasync courseasync()
	{
		return new Courseasync();
	}
	
}