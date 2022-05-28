/**
 * 
 */
package com.pgichure.eprocure.employees.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pgichure.eprocure.employees.models.Employee;
/**
 * @author pgichure
 *
 */
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
  
   public List<Employee> findAllByCompanyId(Long companyId);
  
}
