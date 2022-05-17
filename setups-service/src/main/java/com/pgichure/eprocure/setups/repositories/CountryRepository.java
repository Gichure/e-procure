/**
 * 
 */
package com.pgichure.eprocure.setups.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pgichure.eprocure.setups.models.Country;

/**
 * @author pgichure
 *
 */
public interface CountryRepository extends JpaRepository<Country, Long> {
  
}
