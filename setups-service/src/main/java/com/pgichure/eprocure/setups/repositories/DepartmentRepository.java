/**
 * 
 */
package com.pgichure.eprocure.setups.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pgichure.eprocure.setups.models.Department;
/**
 * @author pgichure
 *
 */
public interface DepartmentRepository extends JpaRepository<Department, Long> {
  
    public List<Department> findAllByCompanyId(Long companyId);
  
}
