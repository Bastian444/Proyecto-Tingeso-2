package com.tingeso.ms5_follow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class Ms5FollowApplication {

	public static void main(String[] args) {
		SpringApplication.run(Ms5FollowApplication.class, args);
	}

}
