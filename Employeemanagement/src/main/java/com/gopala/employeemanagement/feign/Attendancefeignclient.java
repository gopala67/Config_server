package com.gopala.employeemanagement.feign;

import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gopala.employeemanagement.model.Attendancerequest;

@Component
@LoadBalancerClient
@FeignClient(value= "attendancefeign",url="http://localhost:9002/attendance")
public interface Attendancefeignclient {
	
	@RequestMapping(method =RequestMethod.POST,value="/add")
	public Attendancerequest getattedndancerepsonse(@RequestBody Attendancerequest attendancerequest);

}
