/**
 * 
 */
package com.pgichure.eprocure.setups.configs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @author pgichure
 *
 */
@Configuration
public class DocumentationConfig {
	
	private static final Contact DEFAULT_CONTACT = new Contact("Paul Gichure", 
			"www.linkedin.com/in/gichure", 
			"gichurepaul@gmail.com");
	private static final Set<String> DEFAULT_PRODUCES_AND_CONSUMES = new HashSet<String>(Arrays.asList("application/json"));
	public static final String AUTHORIZATION_HEADER = "Authorization";
	
	@Bean
	public Docket allApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.produces(DEFAULT_PRODUCES_AND_CONSUMES)
				.securitySchemes(new ArrayList<>(Arrays.asList(apiKey())))
				.consumes(DEFAULT_PRODUCES_AND_CONSUMES)
				.groupName("EProcure System Setups Service APIs 1.0.0")				
				.select()
				.apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
				.paths(PathSelectors.any())
				.build().apiInfo(apiAllMetaData());
	}
	
	private ApiKey apiKey() {
        return  new ApiKey("Bearer %token", "Authorization", "Header");
    }
	
	private ApiInfo apiAllMetaData() {
		return new ApiInfoBuilder().title("EProcure System Setups Service APIs 1.0.0")
				.description("EProcure System Setups Service APIs 1.0.0")
				.contact(DEFAULT_CONTACT)
				.version("1.0.0").build();
	}
	
}
