/**
 * 
 */
package com.pgichure.eprocure.setups.dtos;

import java.io.Serializable;

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
public class AddressDto implements Serializable{

	private Long id;
	
	private String email;
	
	private String mobileNumber;
	
	private AddressType addressType; 
	
	private String contact_person;
	
	private CountryDto country;
	
	private String zipCode;
	
	private String city;
	
	private String postalAddress;
	
  	private String physicalAddress;
	
	private String street;
	
	private String building;

}
