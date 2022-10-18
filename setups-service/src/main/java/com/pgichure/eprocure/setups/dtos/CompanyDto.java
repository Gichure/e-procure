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
 * @author pgichure
 *
 */
@SuppressWarnings("serial")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Schema(name="Company", description="Company Details")
public class CompanyDto implements Serializable{

	@Schema(name="id", description="The unique identifier")
	private Long id;
	
	@Schema(name="name", description="The company name", required = true)
  	private String name;
  
	@Schema(name="code", description="The company code", required = true)
	private String code;
	
	@Schema(name="group", description="The company group object")
	private CompanyGroupDto group;
	
	@Schema(name="address", description="The address object")
	private AddressDto address;
	
	@Schema(name="tax_identification_number", description="The tax identification number")
	private String tax_identification_number;
	
	@Schema(name="vat_number", description="The vat number")
	private String vat_number;
	
	@Schema(name="country", description="The country object")
  	private CountryDto country;
	
	@Schema(name="currency", description="The currency object")
	private CurrencyDto currency;
	
	@Schema(name="status", description="The status", allowableValues = {"OPEN", "CLOSED"})
	private OpenStatus status;
  
}
