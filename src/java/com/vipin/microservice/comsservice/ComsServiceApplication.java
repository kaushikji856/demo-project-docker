package com.vipin.microservice.comsservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableEurekaClient
@EnableJpaRepositories(basePackages = "com.vipin.microservice.comsservice.repsitory")
@ComponentScan({ "com.vipin" })
@SpringBootApplication
public class ComsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ComsServiceApplication.class, args);
	}
}
