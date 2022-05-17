/**
 * 
 */
package com.pgichure.eprocure.setups.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pgichure.eprocure.setups.models.Currency;
/**
 * @author pgichure
 *
 */
public interface CurrencyRepository extends JpaRepository<Currency, Long> {
  
}
