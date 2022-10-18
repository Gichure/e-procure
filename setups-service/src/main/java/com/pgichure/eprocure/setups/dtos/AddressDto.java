/**
 * 
 */
package com.pgichure.eprocure.setups.dtos;

import java.io.Serializable;

import com.pgichure.eprocure.setups.enums.AddressType;

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
@Schema(name="Address", description="Address Details")
public class AddressDto implements Serializable{

	@Schema(name="id", description="The unique identifier")
	private Long id;
	
	@Schema(name="email", description="The email address", required = true)
	private String email;
	
	@Schema(name="mobileNumber", description="The mobile phone number")
	private String mobileNumber;
	
	@Schema(description = "The type of the address", allowableValues =  {"ORDINARY","EMERGENCY"}, name = "addressType")
	private AddressType addressType; 
	
	@Schema(name="contact_person", description="The name of the contact person")
	private String contact_person;
	
	@Schema(name="country", description="The country object")
	private CountryDto country;
	
	@Schema(name="zipCode", description="The zip code/postal code")
	private String zipCode;
	
	@Schema(name="city", description="The city/town")
	private String city;
	
	@Schema(name="postalAddress", description="The postal address")
	private String postalAddress;
	
	@Schema(name="physicalAddress", description="The physical address")
  	private String physicalAddress;
	
	@Schema(name="street", description="The street/road")
	private String street;
	
	@Schema(name="building", description="The building")
	private String building;

}
