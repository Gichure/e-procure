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
 * 
 * The company group DTO
 * @author pgichure
 *
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CompanyGroupDto implements Serializable{
	
	private Long id;
  
	private String name;
  
	private String code;
	
	private AddressDto address;
	
	private String taxIdentificationNumber;
	
	private String vatNumber;
	
	private CountryDto country;
	
	private CurrencyDto currency;
	
	private OpenStatus status;

}
