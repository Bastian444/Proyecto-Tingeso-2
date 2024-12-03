package com.tingeso.ms6_calculation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class Ms6CalculationApplication {

	public static void main(String[] args) {
		SpringApplication.run(Ms6CalculationApplication.class, args);
	}

}
