package com.trilogyed.eurekaserviceregistryforsummative;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServiceRegistryForSummativeApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaServiceRegistryForSummativeApplication.class, args);
	}

}
