package com.gopala.employeemanagement.aop;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.gopala.employeemanagement.dto.Employeedto;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class Employeeaop {
	
	 final Map<Long,Employeedto> cache=new HashMap<>();
//	 @Around("execution(* com.gopala.employeemanagement.service.impl.Employeeserviceimpl.getdetailsbyid(..))")
//	 public void aroundadvice(ProceedingJoinPoint jointpoint) throws Throwable
//	 {
//		 log.info("Entered before service method call");
//		 jointpoint.proceed();
//		 log.info("Executed after service method call");
//	 }
	 @Around("execution(* com.gopala.employeemanagement.service.impl.Employeeserviceimpl.getdetailsbyid(..))")
	 
	 public Object aroundadvice(ProceedingJoinPoint joinPoint) throws Throwable
	 {
		 log.info("Enetered before service method executed");

Object[] params= joinPoint.getArgs();
Long id=(Long) params[0];
      
        if(cache.get(id) != null)
        {
        	Employeedto  employeedto=	cache.get(id);
        	log.info("taken from cache");
        	return employeedto;
        	
        }else
        {
Object obj= 	joinPoint.proceed();
cache.put(id, (Employeedto) obj);
log.info("entered after service method executed");
log.info("taken from database");
return obj;
        }

	 }

}
