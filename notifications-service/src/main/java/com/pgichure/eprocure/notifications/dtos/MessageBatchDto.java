/**
 * 
 */
package com.pgichure.eprocure.notifications.dtos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
@Schema(name="Message Batch", description="Message Batch Details")
public class MessageBatchDto implements Serializable{

	@Schema(name="id", description="The unique identifier")
    private Long id;
	
	@Schema(name="messages", description="The list of message items")
	private List<MessageDto> messages = new ArrayList<MessageDto>();
	
	@Schema(name="dateSent", description="The date sent")
	private @NonNull Date dateSent;

	@Schema(name="sentBy", description="The sender")
	private String sentBy;
	
	@Schema(name="sendAsBatch", description="Send as a batch", allowableValues = {"YES", "NO"})
	private YesNo sendAsBatch;
	
	@Schema(name="messageType", description="The message type", allowableValues = {"EMAIL", "SMS", "INTERNAL"})
	private @NonNull MessageType messageType;

	@Schema(name="companyId", description="The company ID")
	private @NonNull Long companyId;
	
}
