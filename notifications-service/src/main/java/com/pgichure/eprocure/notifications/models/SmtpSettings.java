/**
 * 
 */
package com.pgichure.eprocure.notifications.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author pgichure
 *
 */
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "smtp_settings")
@Entity
public class SmtpSettings extends Auditable<String>{
	
	@Id
	@Column(name = "id", updatable = false, nullable = false)
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long id;
	
	@Column(name = "host", nullable = false)
	private String host;
	
	@Column(name = "username", nullable = false)
	private String username;
	
	@Column(name = "password", nullable = false)
	private String password;
	
	@Column(name = "protocol", nullable = false)
	private String protocol;
	
	@Column(name = "port", nullable = false)
	private String port;
	
	@Column(name = "auth", nullable = false)
	private String authenticate;

	@Column(name = "company_id", nullable = false)
	private Long companyId;
	
}
