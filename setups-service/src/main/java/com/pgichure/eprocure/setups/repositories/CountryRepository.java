/**
 * 
 */
package com.pgichure.eprocure.setups.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pgichure.eprocure.setups.models.Country;

/**
 * @author pgichure
 *
 */
public interface CountryRepository extends JpaRepository<Country, Long> {
	
	public List<Country> findAllByCode(String code);
  
}
