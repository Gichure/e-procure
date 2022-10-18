/**
 * 
 */
package com.pgichure.eprocure.notifications.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pgichure.eprocure.notifications.models.MessageBatch;

/**
 * @author pgichure
 *
 */
public interface MessageBatchRepository extends JpaRepository<MessageBatch, Long>{

}
