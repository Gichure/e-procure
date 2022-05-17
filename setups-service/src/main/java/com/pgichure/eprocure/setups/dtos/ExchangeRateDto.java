/**
 * 
 */
package com.pgichure.eprocure.setups.dtos;

import java.io.Serializable;
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
public class ExchangeRateDto implements Serializable{

	private Long id;
	
  	private ZonedDateTime effective_from_date;
	
	private ZonedDateTime effective_to_date;
	
	private CurrencyDto base_currency;
	
	private CurrencyDto  target_currency;
	
	private CompanyDto  company;
  
	private BigDecimal  rate;
  
}
