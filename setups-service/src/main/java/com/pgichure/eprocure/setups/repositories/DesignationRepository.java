/**
 * 
 */
package com.pgichure.eprocure.setups.repositories;

import com.pgichure.eprocure.setups.models.Address;
import org.springframework.data.repository.JpaRepository;
/**
 * @author pgichure
 *
 */
public interface DesignationRepository extends JpaRepository<Designation, Long> {
  
    public List<Designation> findAllByDepartmentId(Long departmentId);
  
}
