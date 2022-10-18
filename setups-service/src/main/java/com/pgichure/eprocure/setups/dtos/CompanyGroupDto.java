/**
 * 
 */
package com.pgichure.eprocure.setups.dtos;

import java.io.Serializable;

import com.pgichure.eprocure.setups.enums.OpenStatus;

import io.swagger.v3.oas.annotations.media.Schema;
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
@SuppressWarnings("serial")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Schema(name="Company Group", description="Company Group Details")
public class CompanyGroupDto implements Serializable{
	
	@Schema(name="id", description="The unique identifier")
	private Long id;
  
	@Schema(name="name", description="The company group name", required = true)
	private String name;
  
	@Schema(name="code", description="The company group code", required = true)
	private String code;
	
	@Schema(name="address", description="The address object")
	private AddressDto address;
	
	@Schema(name="taxIdentificationNumber", description="The tax identification number")
	private String taxIdentificationNumber;
	
	@Schema(name="vatNumber", description="The vat number")
	private String vatNumber;
	
	@Schema(name="country", description="The country object")
  	private CountryDto country;
	
	@Schema(name="currency", description="The currency object")
	private CurrencyDto currency;
	
	@Schema(name="status", description="The status", allowableValues = {"OPEN", "CLOSED"})
	private OpenStatus status;

}
