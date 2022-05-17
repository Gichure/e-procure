/**
 * 
 */
package com.pgichure.eprocure.setups.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pgichure.eprocure.setups.models.ExchangeRate;
/**
 * @author pgichure
 *
 */
public interface ExchangeRateRepository extends JpaRepository<ExchangeRate, Long> {
  
}
