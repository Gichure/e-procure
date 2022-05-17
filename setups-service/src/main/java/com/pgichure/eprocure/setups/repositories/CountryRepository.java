/**
 * 
 */
package com.pgichure.eprocure.setups.repositories;

import com.pgichure.eprocure.setups.models.Country;
import org.springframework.data.repository.JpaRepository;
/**
 * @author pgichure
 *
 */
public interface CountryRepository extends JpaRepository<Country, Long> {
  
}
