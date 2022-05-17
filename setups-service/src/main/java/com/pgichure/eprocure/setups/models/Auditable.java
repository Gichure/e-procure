/**
 * 
 */
package com.pgichure.eprocure.setups.models;

import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Type;
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
public class Auditable<T> implements Serializable{

	@CreatedBy
	@Column(name = "created_by", updatable = false, nullable = false)
	private T createdBy;
	
	@LastModifiedBy
	@Column(name = "updated_by")
	private T updatedBy;
	
	@CreatedDate
	@Column(name = "date_created", updatable = false, nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private ZonedDateTime dateCreated;
	
	@LastModifiedDate
	@Column(name = "date_updated", updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private ZonedDateTime dateUpdated;
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Type(type="uuid-char")
	@Column(name="uuid", columnDefinition = "VARCHAR(255)", insertable = false, updatable = false, nullable = false)
	private String uuid;
	
}
