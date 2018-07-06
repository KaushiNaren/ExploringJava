package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableAsync
@EnableScheduling
public class SpringaopDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringaopDemoApplication.class, args);
		System.out.println("This is my First Spring Boot Application....");
	}
}
