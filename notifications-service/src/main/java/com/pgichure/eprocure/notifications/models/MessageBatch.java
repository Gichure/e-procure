/**
 * 
 */
package com.pgichure.eprocure.notifications.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.pgichure.eprocure.notifications.enums.MessageType;
import com.pgichure.eprocure.notifications.enums.YesNo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

/**
 * @author pgichure
 *
 */
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "message_batches")
@Entity
public class MessageBatch {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, updatable = false, nullable = false)
    private Long id;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "batch")
	private List<Message> messages = new ArrayList<Message>();
	
	@Column(name = "date_sent")
	@Temporal(TemporalType.TIMESTAMP)
	private @NonNull Date dateSent;

	@Column(name = "sent_by")
	private String sentBy;
	
	@Column(name = "send_as_batch")
	@Enumerated(EnumType.STRING)
	private YesNo sendAsBatch;
	
	@Column(name = "msg_type", nullable = false)
	@Enumerated(EnumType.STRING)
	private @NonNull MessageType messageType;

	@Column(name = "company_id", nullable = false)
	private @NonNull Long companyId;
	
}
