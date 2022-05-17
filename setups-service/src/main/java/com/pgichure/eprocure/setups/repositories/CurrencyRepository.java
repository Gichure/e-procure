/**
 * 
 */
package com.pgichure.eprocure.setups.repositories;

import com.pgichure.eprocure.setups.models.Currency;
import org.springframework.data.repository.JpaRepository;
/**
 * @author pgichure
 *
 */
public interface CurrencyRepository extends JpaRepository<Currency, Long> {
  
}
