/**
 * 
 */
package com.pgichure.eprocure.setups.services;

import com.pgichure.eprocure.setups.dtos.CompanyDto;

/**
 * The Company service interface
 * @author pgichure
 *
 */
public interface CompanyServiceI{
  
    public CompanyDto save(CompanyDto companyDto);
  
    public CompanyDto findById(Long id);
  
    public CompanyDto update(Long id, CompanyDto companyDto);
  
    public List<CompanyDto> findAll();
  
    public CompanyDto delete(Long id);
  
}
