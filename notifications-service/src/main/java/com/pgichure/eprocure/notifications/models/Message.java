/**
 * 
 */
package com.pgichure.eprocure.notifications.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.pgichure.eprocure.notifications.enums.MessageStatus;
import com.pgichure.eprocure.notifications.enums.MessageType;
import com.pgichure.eprocure.notifications.enums.YesNo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

/**
 * @author pgichure
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "messages")
@Entity
public class Message extends Auditable<String>{
	
	@Id
	@Column(name = "id", updatable = false, nullable = false)
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long id;
	
	@Column(name = "message", nullable = false)
	private String message;
	
	@Column(name = "subject")
	private String subject;
	
	@Column(name = "msg_type", nullable = false)
	@Enumerated(EnumType.STRING)
	private MessageType messageType;
	
	@ManyToOne
	private MessageBatch batch;
	
	@Column(name = "date_sent", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateSent;
	
	@Column(name = "sender", nullable = false)
	private String sender;
	
	@Column(name = "recipient", nullable = false)
	private String recipient;
	
	@Column(name = "receipient_id")
	private Long receivedBy;
	
	@Column(name = "is_read")
	@Enumerated(EnumType.STRING)
	private YesNo read;
	
	@Column(name = "is_sent")
	@Enumerated(EnumType.STRING)
	private YesNo sent;
	
	@Column(name = "status")
	@Enumerated(EnumType.STRING)
	private MessageStatus status;
	
	@Column(name = "remarks")
	private String remarks;
	
	@Column(name = "company_id", nullable = false)
	private @NonNull Long companyId;

}
