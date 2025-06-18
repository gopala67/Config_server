package com.gopala.employeemanagement.confi;

import java.util.concurrent.TimeUnit;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import com.gopala.employeemanagement.dto.Employeedto;

@Component
public class Redisemployeecache {
	
	
	private HashOperations<String, String, Employeedto> hashOperations;
	
	RedisTemplate<String, Employeedto> redisTemplate;
	
	
	public Redisemployeecache(RedisTemplate<String, Employeedto> redisTemplate)
	{
		this.hashOperations=redisTemplate.opsForHash();
		this.redisTemplate=redisTemplate;
	}
	
	public void put(String key,Employeedto value)
	{
		hashOperations.put("Employee", key, value);
		redisTemplate.expire(key, 1, TimeUnit.MINUTES);
	}
	
	public Employeedto get(String key)
	{	redisTemplate.expire(key, 1, TimeUnit.MINUTES);
		return hashOperations.get("Employee", key);

	}

}
