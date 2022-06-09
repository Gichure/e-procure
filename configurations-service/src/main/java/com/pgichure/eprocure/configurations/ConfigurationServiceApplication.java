/**
 * 
 */
package com.pgichure.eprocure.configurations;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author pgichure
 *
 */
@EnableEurekaClient
@SpringBootApplication
@EnableConfigServer
public class ConfigurationServiceApplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
        SpringApplication.run(ConfigurationServiceApplication.class, args);
	}
	
}
