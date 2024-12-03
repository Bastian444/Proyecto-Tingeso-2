package com.tingeso.ms3_request;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class Ms3RequestApplication {

	public static void main(String[] args) {
		SpringApplication.run(Ms3RequestApplication.class, args);
	}

}
