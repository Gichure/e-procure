/**
 * 
 */
package com.pgichure.eprocure.setups.models;

import com.pgichure.eprocure.setups.enums.AddressType;

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
public class AddressDto {

	private Long id;
	
	private String email;
	
	private String mobileNumber;
	
	private AddressType addressType; 
	
	private String contact_person;
	
	private CountryDto country;
	
	private String zip_code;
	
	private String city;
	
	private String postal_address;
	
  private String physical_address;
	
	private String street;
	
	private String building;

}
