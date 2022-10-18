/**
 * 
 */
package com.pgichure.eprocure.notifications.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pgichure.eprocure.notifications.models.Message;

/**
 * @author pgichure
 *
 */
public interface MessageRepository extends JpaRepository<Message, Long>{

}
