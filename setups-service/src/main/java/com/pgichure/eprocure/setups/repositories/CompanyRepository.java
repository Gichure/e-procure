/**
 * The Company repository
 */
package com.pgichure.eprocure.setups.repositories;

import com.pgichure.eprocure.setups.models.Company;
import org.springframework.data.repository.JpaRepository;
/**
 * @author pgichure
 *
 */
public interface CompanyRepository extends JpaRepository<Company, Long> {
  
}
