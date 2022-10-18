/**
 * 
 */
package com.pgichure.eprocure.setups.dtos;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.ZonedDateTime;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author pgichure
 *
 */
@SuppressWarnings("serial")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Schema(name="Exchange Rate", description="Exchange Rate Details")
public class ExchangeRateDto implements Serializable{

	@Schema(description = "Unique identifier of the Rate.")
	private Long id;
	
	@Schema(name="effective_from_date", description="The effective from date", required = true)
  	private ZonedDateTime effective_from_date;
	
  	@Schema(name="effective_to_date", description="The effective to date")
	private ZonedDateTime effective_to_date;
	
	@Schema(name="base_currency", description="The base currency object", required = true)
	private CurrencyDto base_currency;
	
	@Schema(name="target_currency", description="The target currency object", required = true)
	private CurrencyDto  target_currency;
	
	@Schema(name="company", description="The company object", required = true)
	private CompanyDto  company;
  
	@Schema(description = "The rate.", example = "100.00", required = true)
	private BigDecimal  rate;
  
}
