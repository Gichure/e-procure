/**
 * 
 */
package com.pgichure.eprocure.notifications.services;

import java.util.List;

import com.pgichure.eprocure.notifications.dtos.MessageBatchDto;

/**
 * @author pgichure
 *
 */
public interface MessageBatchServiceI {

    public MessageBatchDto save(MessageBatchDto batch);
    
    public MessageBatchDto findById(Long id) throws Exception;
  
    public MessageBatchDto update(Long id, MessageBatchDto batch);
  
    public List<MessageBatchDto> findAll(int page, int size, String sortDir, String sort);
  
    public MessageBatchDto delete(Long id) throws Exception;
    
}
