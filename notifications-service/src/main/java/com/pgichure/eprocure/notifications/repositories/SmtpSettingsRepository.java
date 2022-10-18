/**
 * 
 */
package com.pgichure.eprocure.notifications.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pgichure.eprocure.notifications.models.SmtpSettings;

/**
 * @author pgichure
 *
 */
public interface SmtpSettingsRepository extends JpaRepository<SmtpSettings, Long> {
	
	public List<SmtpSettings> findAllByCompanyId(Long companyId);

}
