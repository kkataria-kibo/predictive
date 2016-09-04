package com.scuti.predictive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
@EnableOAuth2Client
@EnableAuthorizationServer
@EnableMongoRepositories("com.scuti.predictive.repository")
public class PredictiveApplication extends WebMvcConfigurerAdapter {

	public static final int MAX_UPLOAD_SIZE = 100000000;

	public static void main(String[] args) {
		SpringApplication.run(PredictiveApplication.class, args);
	}

	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/login").setViewName("login");
		registry.addViewController("/").setViewName("home");
		registry.addViewController("/product").setViewName("product");
		registry.addViewController("/order").setViewName("order");
		registry.addViewController("/recommend").setViewName("recommend");
		registry.addViewController("/customer").setViewName("customer");
		registry.addViewController("/configuration").setViewName("configuration");
		//registry.addViewController("/reports").setViewName("reports");
		registry.addViewController("/help").setViewName("help");


	}

	/*@Bean
	public CommonsMultipartResolver multipartResolver() {

		CommonsMultipartResolver resolver = new CommonsMultipartResolver();
		//In bytes
		resolver.setMaxUploadSize(MAX_UPLOAD_SIZE);
		return resolver;
	}*/
}
