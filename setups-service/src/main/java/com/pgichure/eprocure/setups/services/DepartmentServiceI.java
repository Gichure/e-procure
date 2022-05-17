/**
 * 
 */
package com.pgichure.eprocure.setups.services;

import com.pgichure.eprocure.setups.dtos.DepartmentDto;

/**
 * The Department service interface
 * @author pgichure
 *
 */
public interface DepartmentServiceI{
  
    public DepartmentDto save(DepartmentDto departmentDto);
  
    public DepartmentDto findById(Long id);
  
    public DepartmentDto update(Long id, DepartmentDto departmentDto);
  
    public List<DepartmentDto> findAll();
  
    public DepartmentDto delete(Long id);
  
}
