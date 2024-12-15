/**
 * 
 */
package com.pgichure.eprocure.employees;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
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
@SpringBootApplication
public class EmployeesServiceApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(EmployeesServiceApplication.class, args);
	}
	
	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}
	
	@Bean
	public OpenAPI customOpenAPI(@Value("${springdoc.version}") String appVersion) {
	 return new OpenAPI()
	        .info(new Info()
	        .title("E-Procure Employees Service APIs")
	        .version(appVersion)
	        .description("E-Procure APIs for the Employees Service")
	        .termsOfService("http://e-procure.com/terms/")
	        .license(new License().name("MIT").url("https://mit-license.org/")));
	}
	
}
