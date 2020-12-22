package com.sollers.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@ComponentScan("com.sollers.*")
@EntityScan( basePackages = {"com.sollers.*"})
@EnableJpaRepositories(basePackages = {"com.sollers.*"})
@EnableSwagger2
@SpringBootApplication
public class EmployeeJpaCrudApplication {

	public static void main(String[] args) 
	{
		SpringApplication.run(EmployeeJpaCrudApplication.class, args);
	}
	
	
	
	@Bean
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}

}
