/**
 * 
 */
package com.pgichure.eprocure.notifications.models;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;

/**
 * @author pgichure
 *
 */
@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class Auditable<T>{

	@CreatedBy
	@Column(name = "created_by", updatable = false, nullable = false)
	private T createdBy;
	
	@LastModifiedBy
	@Column(name = "updated_by")
	private T updatedBy;
	
	@CreatedDate
	@Column(name = "date_created", updatable = false, nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreated;
	
	@LastModifiedDate
	@Column(name = "date_updated", updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateUpdated;
	
	@Column(name="uuid", columnDefinition = "VARCHAR(255)", updatable = false, nullable = false)
	private String uuid = UUID.randomUUID().toString();
	
}
