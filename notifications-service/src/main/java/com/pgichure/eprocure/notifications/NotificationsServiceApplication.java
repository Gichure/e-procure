/**
 * 
 */
package com.pgichure.eprocure.notifications;

import java.util.Properties;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import com.pgichure.eprocure.notifications.dtos.SmtpSettingsDto;
import com.pgichure.eprocure.notifications.services.SmtpSettingsServiceI;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import lombok.RequiredArgsConstructor;


/**
 * 
 * Notifications Service Application
 * @author pgichure
 *
 */
@RequiredArgsConstructor
@EnableEurekaClient
@SpringBootApplication
public class NotificationsServiceApplication {
	
	//private final SmtpSettingsServiceI smtpSettingsService;

	
	public static void main(String[] args) {
		SpringApplication.run(NotificationsServiceApplication.class, args);
	}
	
	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}
	
	@Bean
	public OpenAPI customOpenAPI(@Value("${springdoc.version}") String appVersion) {
	 return new OpenAPI()
	        .info(new Info()
	        .title("E-Procure Notifications Service APIs")
	        .version(appVersion)
	        .description("E-Procure APIs for the Notifications Service")
	        .termsOfService("http://e-procure.com/terms/")
	        .license(new License().name("MIT").url("https://mit-license.org/")));
	}
	
	@Bean
	public JavaMailSender getJavaMailSender() throws Exception {
		
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		
		/*
		SmtpSettingsDto settings = smtpSettingsService.getDefaultSettings(0L);
		
		if(settings != null) {
			
			mailSender.setHost(settings.getHost());
		    mailSender.setPort(Integer.parseInt(settings.getPort()));
		    
		    mailSender.setUsername(settings.getUsernmae());
		    mailSender.setPassword(settings.getPassword());
		    
		    Properties props = mailSender.getJavaMailProperties();
		    props.put("mail.transport.protocol", settings.getProtocol());
		    props.put("mail.smtp.auth", settings.getAuthenticate());
		    props.put("mail.smtp.starttls.enable", "true");
		    props.put("mail.debug", "true");
		}
	    */
	    
	    return mailSender;
	}
	
}
