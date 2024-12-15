/**
 * 
 */
package com.pgichure.eprocure.workflow;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

/**
 * @author pgichure
 *
 */
@SpringBootApplication
public class WorkflowServiceApplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(WorkflowServiceApplication.class, args);
	}
	
	@Bean
	public OpenAPI customOpenAPI(@Value("${springdoc.version}") String appVersion) {
	 return new OpenAPI()
	        .info(new Info()
	        .title("E-Procure Workflow Service APIs")
	        .version(appVersion)
	        .description("E-Procure APIs for the Workflow Service")
	        .termsOfService("http://e-procure.com/terms/")
	        .license(new License().name("MIT").url("https://mit-license.org/")));
	}
	
}
