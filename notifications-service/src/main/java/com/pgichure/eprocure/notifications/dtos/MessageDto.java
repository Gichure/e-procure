/**
 * 
 */
package com.pgichure.eprocure.notifications.dtos;

import java.io.Serializable;
import java.util.Date;

import com.pgichure.eprocure.notifications.enums.MessageStatus;
import com.pgichure.eprocure.notifications.enums.MessageType;
import com.pgichure.eprocure.notifications.enums.YesNo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

/**
 * @author pgichure
 *
 */
@SuppressWarnings("serial")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Schema(name="Message", description="Message Details")
public class MessageDto implements Serializable{

	@Schema(name="id", description="The unique identifier")
	private Long id;
	
	@Schema(name="message", description="The message")
	private String message;
	
	@Schema(name="subject", description="The subject")
	private String subject;
	
	@Schema(name="messageType", description="The message type", allowableValues = {"EMAIL", "SMS", "INTERNAL"})
	private MessageType messageType;
	
	@Schema(name="batchId", description="The batch ID")
	private Long batchId;
	
	@Schema(name="dateSent", description="The date sent")
	private Date dateSent;
	
	@Schema(name="sender", description="The address of the sender")
	private String sender;
	
	@Schema(name="recipient", description="The address of the recipient")
	private String recipient;
	
	@Schema(name="receivedById", description="The ID of the recipient")
	private Long receivedById;
	
	@Schema(name="read", description="The read status", allowableValues = {"YES", "NO"})
	private YesNo read;
	
	@Schema(name="sent", description="The sent status", allowableValues = {"YES", "NO"})
	private YesNo sent;
	
	@Schema(name="status", description="The status", allowableValues = {"DRAFT","READ","UN_READ","SCHEDULED","SENT","NOT_SENT"})
	private MessageStatus status;
	
	@Schema(name="remarks", description="The remarks")
	private String remarks;
	
	@Schema(name="companyId", description="The company ID")
	private @NonNull Long companyId;
	
}
