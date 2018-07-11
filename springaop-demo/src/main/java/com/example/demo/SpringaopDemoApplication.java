package com.example.demo;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
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

	@Bean
	public CommandLineRunner run(ApplicationContext context) {
		return args -> {
			String[] beans = context.getBeanDefinitionNames();
			System.out.println("-------------------------------");
			Arrays.stream(beans).forEach(System.out::println);
			System.out.println("-------------------------------");

		};

	}
}
