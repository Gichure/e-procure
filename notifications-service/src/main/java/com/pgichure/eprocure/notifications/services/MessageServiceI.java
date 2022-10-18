/**
 * 
 */
package com.pgichure.eprocure.notifications.services;

import java.util.List;

import com.pgichure.eprocure.notifications.dtos.MessageDto;


/**
 * @author pgichure
 *
 */
public interface MessageServiceI {

    public MessageDto save(MessageDto message);
    
    public MessageDto findById(Long id) throws Exception;
  
    public MessageDto update(Long id, MessageDto message);
  
    public List<MessageDto> findAll(int page, int size, String sortDir, String sort);
  
    public MessageDto delete(Long id) throws Exception;
    
}
