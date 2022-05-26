/**
 * 
 */
package com.pgichure.eprocure.employees.services;

import java.util.List;

import com.pgichure.eprocure.employees.dtos.PersonDto;

/**
 * The Person service interface
 * @author pgichure
 *
 */
public interface PersonServiceI{
  
    public PersonDto save(PersonDto addressDto);
  
    public PersonDto findById(Long personId) throws Exception;
  
    public PersonDto update(Long personId, PersonDto personDto);
  
    public List<PersonDto> findAllByCompanyId(Long companyId, int page, int size, String sortDir, String sort);
  
    public List<PersonDto> findAll(int page, int size, String sortDir, String sort);
  
    public PersonDto delete(Long personId) throws Exception;
  
}
