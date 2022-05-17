/**
 * 
 */
package com.pgichure.eprocure.setups.services;

import java.util.List;

import com.pgichure.eprocure.setups.dtos.CompanyGroupDto;

/**
 * The CompanyGroup service interface
 * @author pgichure
 *
 */
public interface CompanyGroupServiceI{
  
    public CompanyGroupDto save(CompanyGroupDto companyGroupDto);
  
    public CompanyGroupDto findById(Long id);
  
    public CompanyGroupDto update(Long id, CompanyGroupDto companyGroupDto);
  
    public List<CompanyGroupDto> findAll(int page, int size, String sortDir, String sort);
  
    public CompanyGroupDto delete(Long id);
  
}
