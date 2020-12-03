package com.digimaster.mybackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class MybackendApplication {
	static final Logger logger = 
	        LoggerFactory.getLogger(MybackendApplication.class);
	
	public static void main(String[] args) {
		logger.info("Before Starting application");
		SpringApplication.run(MybackendApplication.class, args);
		logger.debug("Starting my application in debug with {} arguments", args.length);
		logger.info("Starting my application with {} arguments.", args.length);
	}

}
