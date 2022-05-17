/**
 * 
 */
package com.pgichure.eprocure.setups.dtos;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author pgichure
 *
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ExchangeRate extends Auditable<String>{

	private Long id;
	
  private ZonedDateTime effective_from_date;
	
	private ZonedDateTime effective_to_date;
	
	private CurrencyDto base_crrency;
	
	private CurrencyDto  target_currency;
	
	private CompanyDto  company;
  
	private BigDecimal  rate;
  
}
