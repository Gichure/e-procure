/**
 * 
 */
package com.pgichure.eprocure.setups.services;

import java.util.List;

import com.pgichure.eprocure.setups.dtos.DepartmentDto;

/**
 * The Department service interface
 * @author pgichure
 *
 */
public interface DepartmentServiceI{
  
    public DepartmentDto save(DepartmentDto departmentDto);
  
    public DepartmentDto findById(Long id) throws Exception;
  
    public DepartmentDto update(Long id, DepartmentDto departmentDto);
  
    public List<DepartmentDto> findAll(int page, int size, String sortDir, String sort);
  
    public DepartmentDto delete(Long id) throws Exception;
  
}
