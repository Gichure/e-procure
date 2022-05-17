/**
 * 
 */
package com.pgichure.eprocure.setups.services;

import com.pgichure.eprocure.setups.dtos.DesignationDto;

/**
 * The Designation service interface
 * @author pgichure
 *
 */
public interface DesignationServiceI{
  
    public DesignationDto save(DesignationDto designationDto);
  
    public DesignationDto findById(Long id);
  
    public DesignationDto update(Long id, DesignationDto designationDto);
  
    public List<DesignationDto> findAll();
  
    public DesignationDto delete(Long id);
  
}
