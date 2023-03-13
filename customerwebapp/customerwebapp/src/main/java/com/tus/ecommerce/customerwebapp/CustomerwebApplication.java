package com.tus.ecommerce.customerwebapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EnableEurekaClient
@SpringBootApplication
public class CustomerwebApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerwebApplication.class, args);
	}

}
