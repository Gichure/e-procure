/**
 * 
 */
package com.pgichure.eprocure.setups.repositories;

import com.pgichure.eprocure.setups.models.Department;
import org.springframework.data.repository.JpaRepository;
/**
 * @author pgichure
 *
 */
public interface DepartmentRepository extends JpaRepository<Department, Long> {
  
    public List<Department> findAllByCompanyId(Long companyId);
  
}
