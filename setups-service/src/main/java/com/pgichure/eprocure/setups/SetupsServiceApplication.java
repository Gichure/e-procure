/**
 * 
 */
package com.pgichure.eprocure.setups;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.headers.Header;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.media.StringSchema;
import io.swagger.v3.oas.models.parameters.Parameter;
import io.swagger.v3.oas.models.security.SecurityScheme;

/**
 * @author pgichure
 *
 */
@EnableEurekaClient
@SpringBootApplication
public class SetupsServiceApplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(SetupsServiceApplication.class, args);
	}
	
	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}
	
	@Bean
	public OpenAPI customOpenAPI(@Value("${springdoc.version}") String appVersion) {
	 return new OpenAPI()
	       /* .components(new Components()
	        		.addSecuritySchemes("basicScheme", new SecurityScheme()
	        				.type(SecurityScheme.Type.HTTP).scheme("basic"))
	        .addParameters("myHeader1", new Parameter().in("header").schema(new StringSchema())
	        		.name("myHeader1")).addHeaders("myHeader2", new Header()
	        				.description("myHeader2 header").schema(new StringSchema())))*/
	        .info(new Info()
	        .title("E-Procure Setups Service APIs")
	        .version(appVersion)
	        .description("E-Procure APIs for the Setups Service")
	        .termsOfService("http://e-procure.com/terms/")
	        .license(new License().name("Apache 2.0").url("http://e-procure.com")));
	}
}
