package com.aml;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AmlApplication {
	private final static Logger logger = LoggerFactory.getLogger(AmlApplication.class);
	
	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(AmlApplication.class);
		//不打印banner
		app.setBannerMode(Banner.Mode.OFF);
		app.run(args);
		logger.info("AmlApplication Start-Up Complete !!!");
	}
}
