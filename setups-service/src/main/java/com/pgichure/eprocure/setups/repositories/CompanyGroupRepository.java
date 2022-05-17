/**
 * 
 */
package com.pgichure.eprocure.setups.repositories;

import com.pgichure.eprocure.setups.models.CompanyGroup;
import org.springframework.data.repository.JpaRepository;
/**
 * @author pgichure
 *
 */
public interface CompanyGroupRepository extends JpaRepository<CompanyGroup, Long> {
  
}
