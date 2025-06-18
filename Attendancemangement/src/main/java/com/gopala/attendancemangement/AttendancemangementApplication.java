package com.gopala.attendancemangement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AttendancemangementApplication {

	public static void main(String[] args) {
		SpringApplication.run(AttendancemangementApplication.class, args);
	}

}
