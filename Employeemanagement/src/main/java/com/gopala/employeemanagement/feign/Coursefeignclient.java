package com.gopala.employeemanagement.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gopala.employeemanagement.model.Courserequest;

@Component
@FeignClient(value = "coursefeign",url="http://localhost:9003/course")
public interface Coursefeignclient {
	
	@RequestMapping(method = RequestMethod.POST,value="/posts")
	public Courserequest getcourseresponse(@RequestBody Courserequest courserequest);

}
