/**
 * 
 */
package com.pgichure.eprocure.configurations;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
/**
 * @author pgichure
 *
 */
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
