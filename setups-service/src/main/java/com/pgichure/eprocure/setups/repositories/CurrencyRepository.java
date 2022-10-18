/**
 * 
 */
package com.pgichure.eprocure.setups.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pgichure.eprocure.setups.models.Currency;
/**
 * @author pgichure
 *
 */
public interface CurrencyRepository extends JpaRepository<Currency, Long> {
	
	public List<Currency> findAllByCode(String code);
  
}
