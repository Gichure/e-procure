/**
 * The Company repository
 */
package com.pgichure.eprocure.setups.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pgichure.eprocure.setups.models.Company;

/**
 * @author pgichure
 *
 */
public interface CompanyRepository extends JpaRepository<Company, Long> {
  
}
