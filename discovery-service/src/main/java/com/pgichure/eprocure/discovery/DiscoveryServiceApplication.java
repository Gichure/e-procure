/**
 * 
 */
package com.pgichure.eprocure.discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author pgichure
 *
 */
@EnableEurekaServer
@SpringBootApplication
public class DiscoveryServiceApplication {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(DiscoveryServiceApplication.class, args);
	}
}
