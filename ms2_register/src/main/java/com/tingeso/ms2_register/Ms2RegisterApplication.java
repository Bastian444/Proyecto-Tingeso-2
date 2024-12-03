package com.tingeso.ms2_register;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class Ms2RegisterApplication {

	public static void main(String[] args) {
		SpringApplication.run(Ms2RegisterApplication.class, args);
	}

}
