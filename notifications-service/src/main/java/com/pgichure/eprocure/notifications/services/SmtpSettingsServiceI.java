/**
 * 
 */
package com.pgichure.eprocure.notifications.services;

import java.util.List;

import com.pgichure.eprocure.notifications.dtos.SmtpSettingsDto;


/**
 * @author pgichure
 *
 */
public interface SmtpSettingsServiceI {

    public SmtpSettingsDto save(SmtpSettingsDto settings);
    
    public SmtpSettingsDto findById(Long id) throws Exception;
  
    public SmtpSettingsDto update(Long id, SmtpSettingsDto settings);
  
    public List<SmtpSettingsDto> findAll(int page, int size, String sortDir, String sort);
  
    public SmtpSettingsDto delete(Long id) throws Exception;
    
    public SmtpSettingsDto getDefaultSettings(Long companyId) throws Exception;
    
}
