/**
 * 
 */
package com.pgichure.eprocure.notifications.dtos;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;

import com.pgichure.eprocure.notifications.enums.MessageStatus;
import com.pgichure.eprocure.notifications.enums.MessageType;
import com.pgichure.eprocure.notifications.enums.YesNo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author pgichure
 *
 */
@SuppressWarnings("serial")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Schema(name="SMTP Settings", description="SMTP Settings Details")
public class SmtpSettingsDto implements Serializable{

	@Schema(name="id", description="The unique identifier")
	private Long id;
	
	@Schema(name = "host", description = "Host")
	private String host;
	
	@Schema(name = "username", description = "Username")
	private String username;
	
	@Schema(name = "password", description = "Password")
	private String password;
	
	@Schema(name = "protocol", description = "Protocol")
	private String protocol;
	
	@Schema(name = "port", description = "Port")
	private String port;
	
	@Schema(name = "authenticate", description = "SMTP Authenticate")
	private String authenticate;
	
	@Schema(name = "companyId", description = "Company ID")
	private Long companyId;
	
}
