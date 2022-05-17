/**
 * 
 */
package com.pgichure.eprocure.setups.services;

import com.pgichure.eprocure.setups.dtos.CompanyGroupDto;

/**
 * The Company service interface
 * @author pgichure
 *
 */
public interface CompanyGroupServiceI{
  
    public CompanyGroupDto save(CompanyGroupDto companyGroupDto);
  
    public CompanyGroupDto findById(Long id);
  
    public CompanyGroupDto update(Long id, CompanyGroupDto companyGroupDto);
  
    public List<CompanyGroupDto> findAll();
  
    public CompanyGroupDto delete(Long id);
  
}
