package com.gopala.employeemanagement.confi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.gopala.employeemanagement.dto.Employeedto;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class Redisconfiguration {
	
	
	@Bean
	public RedisConnectionFactory redisConnectionFactory() {
		// Configure standalone Redis server connection
		RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();
		redisStandaloneConfiguration.setHostName("localhost");
		redisStandaloneConfiguration.setPort(6379);
		// redisStandaloneConfiguration.setPassword("yourpassword"); // Uncomment if
		// Redis requires a password

		// Create and return the JedisConnectionFactory
		return new JedisConnectionFactory(redisStandaloneConfiguration);
	}

	@Bean
	//template creation
	public RedisTemplate<String, Employeedto> redisTemplate() {
		RedisTemplate<String, Employeedto> template = new RedisTemplate<>();
		template.setConnectionFactory(redisConnectionFactory());

		// Set serializers
		setSerializer(template);

		log.info("RedisTemplate for Coursedto is instantiated");
		return template;
	}
//seralization and desaralization
	private <K, V> void setSerializer(RedisTemplate<K, V> template) {
		// Use String serializer for keysq
		template.setKeySerializer(new StringRedisSerializer());
		template.setHashKeySerializer(new StringRedisSerializer());

		// Use JSON serializer for values
		template.setValueSerializer(new GenericJackson2JsonRedisSerializer());
		template.setHashValueSerializer(new GenericJackson2JsonRedisSerializer());
	}


}
