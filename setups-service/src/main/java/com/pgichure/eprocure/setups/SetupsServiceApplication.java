/**
 * 
 */
package com.pgichure.eprocure.setups;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

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
}
