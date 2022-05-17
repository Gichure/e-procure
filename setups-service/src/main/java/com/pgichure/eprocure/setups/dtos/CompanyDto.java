/**
 * 
 */
package com.pgichure.eprocure.setups.dtos;

import java.io.Serializable;

import com.pgichure.eprocure.setups.enums.OpenStatus;

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
public class CompanyDto implements Serializable{

	private Long id;
	
  	private String name;
  
	private String code;
	
	private CompanyGroupDto group;
	
	private AddressDto address;
	
	private String tax_identification_number;
	
	private String vat_number;
	
  	private CountryDto country;
	
	private CurrencyDto currency;
	
	private OpenStatus status;
  
}
