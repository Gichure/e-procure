/**
 * 
 */
package com.pgichure.eprocure.notifications.configs;

import java.util.Optional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * @author pgichure
 *
 */
@Configuration
@EnableJpaAuditing(auditorAwareRef = "aware")
public class AuditingConfig {

	
	@Bean
	public AuditorAware<String> aware() {
		return () -> Optional.of("ADMIN");
	}
	
}
