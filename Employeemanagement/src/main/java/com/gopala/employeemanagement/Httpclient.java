package com.gopala.employeemanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.gopala.employeemanagement.model.Courserequest;

@Component
public class Httpclient {
	@Autowired
	private  RestTemplate restTemplate;
	
	public void postforcourse(Courserequest courserequest)
	{
		restTemplate.postForObject("http://localhost:9003/posts", courserequest, Courserequest.class);
//		String url="http://localhost:9003/posts";
//		org.springframework.http.HttpHeaders httpHeaders=new org.springframework.http.HttpHeaders();
//		httpHeaders.set("Content-Type", "application/json");
//		HttpEntity<Courserequest> httpEntity=new HttpEntity<>(courserequest,httpHeaders);
//		restTemplate.exchange(url, HttpMethod.POST, httpEntity, Courserequest.class);
	}
	

}
