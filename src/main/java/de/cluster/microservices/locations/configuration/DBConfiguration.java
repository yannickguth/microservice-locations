package de.cluster.microservices.locations.configuration;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import de.cluster.microservices.locations.service.LocationService;

@Configuration
public class DBConfiguration {
	
	@Autowired
	private LocationService locationService;


	@Bean
	public InitializingBean insert() {

		return new InitializingBean() {
			@Override
			public void afterPropertiesSet() {
				locationService.createData();
			}

		};
	}
}
