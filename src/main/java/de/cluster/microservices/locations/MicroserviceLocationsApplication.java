package de.cluster.microservices.locations;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MicroserviceLocationsApplication {

	public static void main(String[] args) {
		SpringApplication.run(
				MicroserviceLocationsApplication.class, args);
	}
}
