package com.tingeso.ms4_evaluation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class Ms4EvaluationApplication {

	public static void main(String[] args) {
		SpringApplication.run(Ms4EvaluationApplication.class, args);
	}

}
