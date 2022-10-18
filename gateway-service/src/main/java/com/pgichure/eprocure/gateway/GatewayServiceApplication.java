/**
 * 
 */
package com.pgichure.eprocure.gateway;

import java.util.ArrayList;
import java.util.List;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.route.RouteDefinitionLocator;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

/**
 * @author Hp
 *
 */
@EnableEurekaClient
@SpringBootApplication
public class GatewayServiceApplication {
	
	@Autowired
	RouteDefinitionLocator locator;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(GatewayServiceApplication.class, args);
	}
	
	@Bean
	public List<GroupedOpenApi> apis() {
	   List<GroupedOpenApi> groups = new ArrayList<GroupedOpenApi>();
	   List<RouteDefinition> definitions = locator.getRouteDefinitions().collectList().block();
	   definitions.stream().filter(routeDefinition -> routeDefinition.getId().matches(".*-service")).forEach(routeDefinition -> {
	      String name = routeDefinition.getId().replaceAll("-service", "");
	      GroupedOpenApi.builder().pathsToMatch("/" + name + "/**").group(name).build();
	   });
	   
	   return groups;
	}
}
