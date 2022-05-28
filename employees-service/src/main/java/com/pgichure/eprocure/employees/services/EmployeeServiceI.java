/**
 * 
 */
package com.pgichure.eprocure.employees.services;

import java.util.List;

import com.pgichure.eprocure.employees.dtos.EmployeeDto;

/**
 * The Employee service interface
 * @author pgichure
 *
 */
public interface EmployeeServiceI{
    
    public EmployeeDto save(EmployeeDto employeeDto);
  
    public EmployeeDto findById(Long employeeId) throws Exception;
  
    public EmployeeDto update(Long employeeId, EmployeeDto personDto);
  
    public List<EmployeeDto> findAllByCompanyId(Long companyId, int page, int size, String sortDir, String sort);
  
    public List<EmployeeDto> findAll(int page, int size, String sortDir, String sort);
  
    public EmployeeDto delete(Long employeeId) throws Exception;
  
}
