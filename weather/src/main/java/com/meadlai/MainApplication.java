package com.meadlai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class MainApplication {

	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
		log.info("");
		log.info("");
		log.info("");
		log.info("Get today information:");
		log.info("    http://localhost:9090/weather/today");
		log.info("");
		log.info("");
		log.info("Set Sunny");
		log.info("    http://localhost:9090/weather/set/1");
		log.info("");
		log.info("");
		log.info("Set Rain");
		log.info("    http://localhost:9090/weather/set/0");
		log.info("");
		log.info("");

	}

}
