package com.scuti.predictive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


@SpringBootApplication
@EnableMongoRepositories("com.scuti.predictive.repository")
public class PredictiveApplication {

	public static void main(String[] args) {
		SpringApplication.run(PredictiveApplication.class, args);
	}
}
