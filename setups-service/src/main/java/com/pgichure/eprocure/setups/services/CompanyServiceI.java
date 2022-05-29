/**
 * 
 */
package com.pgichure.eprocure.setups.services;

import java.util.List;

import com.pgichure.eprocure.setups.dtos.CompanyDto;

/**
 * The Company service interface
 * @author pgichure
 *
 */
public interface CompanyServiceI{
  
    public CompanyDto save(CompanyDto companyDto);
  
    public CompanyDto findById(Long id) throws Exception;
  
    public CompanyDto update(Long id, CompanyDto companyDto);
  
    public List<CompanyDto> findAll(int page, int size, String sortDir, String sort);
  
    public CompanyDto delete(Long id) throws Exception;
  
}
