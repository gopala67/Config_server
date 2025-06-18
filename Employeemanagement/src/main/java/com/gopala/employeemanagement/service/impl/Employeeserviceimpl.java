package com.gopala.employeemanagement.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;

import com.gopala.employeemanagement.Httpclient;
import com.gopala.employeemanagement.async.Courseasync;
import com.gopala.employeemanagement.confi.Redisemployeecache;
import com.gopala.employeemanagement.dto.Employeedto;
import com.gopala.employeemanagement.entity.Employeedetails;
import com.gopala.employeemanagement.feign.Attendancefeignclient;
import com.gopala.employeemanagement.feign.Coursefeignclient;
import com.gopala.employeemanagement.model.Attendancerequest;
import com.gopala.employeemanagement.model.Courserequest;
import com.gopala.employeemanagement.model.Employeerequest;
import com.gopala.employeemanagement.repository.Employeerepository;
import com.gopala.employeemanagement.service.Employeeservice;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
@AllArgsConstructor
@Slf4j
public class Employeeserviceimpl  implements Employeeservice{
	
	 //final Map<Long,Employeedto> cache=new HashMap<>();
	
	//private final RestTemplate restTemplate;
	
	
	private final Employeerepository employeerepository;
	private final Httpclient httpclient;

	private final  Coursefeignclient coursefeignclient;
	private final Attendancefeignclient attendancefeignclient;

	private final Courseasync courseasync;
	
	private final Redisemployeecache redisemployeecache;
	
@Override
//s@CircuitBreaker(name = "employeecircuitbreaker",fallbackMethod = "dummyreposnsemethod")
	public Employeerequest  addetails(Employeerequest request) {
	
         Long started=	System.currentTimeMillis();

		
		Employeedetails details=new Employeedetails();
		details.setName(request.getName());
		details.setPlace(request.getPlace());
		Employeedetails employeedetails=  	employeerepository.save(details);
		Courserequest courserequest=new Courserequest();
		courserequest.setEmployeeid(employeedetails.getId());
		courserequest.setEmployeeid(employeedetails.getId());
		courserequest.setCoursename(request.getCoursename());
		courserequest.setSkillset(request.getSkillset());
		courserequest.setExperience(request.getExperience());
		//CompletableFuture<Courserequest> courserequest1=	courseasync.courserequestinasync(courserequest);
			
		//restTemplate.postForObject("http://localhost:9003/posts", courserequest, Courserequest.class);
//		String url="http://localhost:9003/posts";
//		org.springframework.http.HttpHeaders httpHeaders=new org.springframework.http.HttpHeaders();
//		httpHeaders.set("Content-Type", "application/json");
//		HttpEntity<Courserequest> httpEntity=new HttpEntity<>(courserequest,httpHeaders);
//		
//		
//		//restTemplate.exchange(url, HttpMethod.POST,courserequest , Courserequest.class);
//		//restTemplate.exchange(url, HttpMethod.POST, courserequest,Courserequest.class);
//		restTemplate.exchange(url, HttpMethod.POST, httpEntity, Courserequest.class);
		//httpclient.postforcourse(courserequest);
		//coursefeignclient.getcourseresponse(courserequest);
		//CompletableFuture<Courserequest> courserequest1=	courseasync.courserequestinasync(courserequest);
		Attendancerequest attendancerequest=new Attendancerequest();
		attendancerequest.setEmployeeId(request.getEmployeeid());
		attendancerequest.setYear(request.getYear());
		attendancerequest.setMonth(request.getMonth());
		attendancerequest.setDaysPresent(request.getDaysPresent());
		//attendancefeignclient.getattedndancerepsonse(attendancerequest);
		CompletableFuture<Courserequest> courserequest1=	courseasync.courserequestinasync(courserequest);
		CompletableFuture<Attendancerequest> attendancerequest1=		courseasync.attendancerequestinasync(attendancerequest);
		CompletableFuture.allOf(courserequest1,attendancerequest1).join();
		
		Long ended = System.currentTimeMillis();
		
		Long diff = ended - started;
		System.out.println("seconds:" + diff / 1000);
		
	
		return request;

		
		
		
	
	
	
	
	
	}

         @Override
         public Employeedto getdetailsbyid(Long id)
         {
//        	 log.info("enterd");
//        	 
//        	 if(cache.get(id)!=null)
//        	 {
//        		 Employeedto  dtos=	 cache.get(id);
//        		 log.info("taken from cache");
//        		 return dtos;
//        	 }else
//        	 {
//        		 
        	 if (redisemployeecache.get(id.toString()) != null) {
    			System.out.println("taken from  redis cache");
    			return redisemployeecache.get(id.toString());
//     		}
        	 }else {
        	 Optional<Employeedetails> details=    	 employeerepository.findById(id);
        
        	 
        	 if(details.isPresent())
        	 {

Employeedetails  details1=	 details.get();

Employeedto dto=new Employeedto();
dto.setId(details1.getId());
dto.setName(details1.getName());
dto.setPlace(details1.getPlace());
//cache.put(id, dto);
redisemployeecache.put(id.toString(), dto);

log.info("taken from database");

return dto;
        	 }
         }
			return null;
         }

@Override
public List<Employeedetails> findByName(String name)
{
	return employeerepository.findByName(name);
}
@Override
public
List<Employeedetails>  findByNameAndPlace(String name,String place)
{
	return employeerepository.findByNameAndPlace(name, place);
}

@Override
public List<Employeedetails>   findByNameOrPlace(String name,String place){
return	employeerepository.findByNameOrPlace(name, place);
	
}
//@Override
//@CircuitBreaker(name = "emplopyeecircuit",fallbackMethod = "getdummymethod")
//public String getdetails()
//{
//	System.out.println("my service method executed");
//	throw new RuntimeException("hi i  got a error");
//}
//public String getdummymethod(Throwable ex)
//{
//	System.out.println("fallback method executed");
//	return "dummy response";
//}



}
         

//}

