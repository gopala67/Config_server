package com.gopala.employeemanagement.async;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.gopala.employeemanagement.feign.Attendancefeignclient;
import com.gopala.employeemanagement.feign.Coursefeignclient;
import com.gopala.employeemanagement.model.Attendancerequest;
import com.gopala.employeemanagement.model.Courserequest;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Component
public class Courseasync {
	@Autowired
	private   Coursefeignclient coursefeignclient;
	@Autowired
	private  Attendancefeignclient attendancefeignclient;
	@Async
	//@CircuitBreaker(name = "sdfgh",fallbackMethod = "dummy")
	public CompletableFuture<Courserequest> courserequestinasync(Courserequest courserequest)
	{
		//coursefeignclient.getcourseresponse(courserequest);
	return	CompletableFuture.completedFuture(coursefeignclient.getcourseresponse(courserequest));
	}
	@Async
	//@CircuitBreaker(name = "attendancecircuit",fallbackMethod = "getdummyresponse")
	public CompletableFuture<Attendancerequest> attendancerequestinasync(Attendancerequest attendancerequest) {
		attendancefeignclient.getattedndancerepsonse(attendancerequest);
	return	CompletableFuture.completedFuture(attendancefeignclient.getattedndancerepsonse(attendancerequest));
	}
	
	/*public CompletableFuture<Attendancerequest> getdummyresponse (Attendancerequest attendancerequest,Throwable ex)
	{
		Attendancerequest attendancerequest2=new Attendancerequest();
		attendancerequest2.setYear(2021);
		attendancerequest2.setMonth(0);
		attendancerequest2.setDaysPresent(0);
		System.out.println("executed");
		return CompletableFuture.completedFuture(attendancerequest2);
		
	}
	public CompletableFuture<Courserequest> dummy(Courserequest courserequest,Throwable ex)
	{
		Courserequest courserequest2=new Courserequest();
		courserequest2.setCoursename("NA");
		courserequest2.setSkillset("Na");
		System.out.println(("dummy done"));
		return CompletableFuture.completedFuture(courserequest2);
	}*/
	
	

}
