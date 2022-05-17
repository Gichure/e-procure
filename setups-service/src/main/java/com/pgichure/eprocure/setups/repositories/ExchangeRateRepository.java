/**
 * 
 */
package com.pgichure.eprocure.setups.repositories;

import com.pgichure.eprocure.setups.models.ExchangeRate;
import org.springframework.data.repository.JpaRepository;
/**
 * @author pgichure
 *
 */
public interface ExchangeRateRepository extends JpaRepository<ExchangeRate, Long> {
  
}
