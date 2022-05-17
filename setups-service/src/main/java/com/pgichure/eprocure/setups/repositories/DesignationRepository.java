/**
 * 
 */
package com.pgichure.eprocure.setups.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pgichure.eprocure.setups.models.Designation;

/**
 * @author pgichure
 *
 */
public interface DesignationRepository extends JpaRepository<Designation, Long> {
  
    public List<Designation> findAllByDepartmentId(Long departmentId);
  
}
