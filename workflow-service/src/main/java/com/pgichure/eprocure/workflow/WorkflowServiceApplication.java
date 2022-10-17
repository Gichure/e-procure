/**
 * 
 */
package com.pgichure.eprocure.workflow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author pgichure
 *
 */
@EnableEurekaClient
@SpringBootApplication
public class WorkflowServiceApplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(WorkflowServiceApplication.class, args);
	}
	
}
