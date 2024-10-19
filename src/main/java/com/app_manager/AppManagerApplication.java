package com.app_manager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class AppManagerApplication {

	private static final Logger logger = LoggerFactory.getLogger(AppManagerApplication.class);

	public static void main(String[] args) {
		
		SpringApplication.run(AppManagerApplication.class, args);
	}

}
