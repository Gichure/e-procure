/**
 * 
 */
package com.pgichure.eprocure.inventory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


/**
 * 
 * Employees Service Application
 * @author pgichure
 *
 */
@EnableEurekaClient
@SpringBootApplication
public class InventoryServiceApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}
	
}
