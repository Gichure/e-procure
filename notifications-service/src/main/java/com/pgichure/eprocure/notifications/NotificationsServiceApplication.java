/**
 * 
 */
package com.pgichure.eprocure.notifications;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;


/**
 * 
 * Employees Service Application
 * @author pgichure
 *
 */
@EnableEurekaClient
@SpringBootApplication
public class NotificationsServiceApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(NotificationsServiceApplication.class, args);
	}
	
	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}
	
	@Bean
	public OpenAPI customOpenAPI(@Value("${springdoc.version}") String appVersion) {
	 return new OpenAPI()
	        .info(new Info()
	        .title("E-Procure Notifications Service APIs")
	        .version(appVersion)
	        .description("E-Procure APIs for the Notifications Service")
	        .termsOfService("http://e-procure.com/terms/")
	        .license(new License().name("MIT").url("https://mit-license.org/")));
	}
	
}
