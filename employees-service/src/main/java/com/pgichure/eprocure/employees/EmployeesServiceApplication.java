/**
 * 
 */
package com.pgichure.eprocure.employees;

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
public class EmployeesServiceApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(EmployeesServiceApplication.class, args);
	}
	
}
