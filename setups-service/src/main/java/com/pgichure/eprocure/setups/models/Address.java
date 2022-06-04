/**
 * 
 */
package com.pgichure.eprocure.setups.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
@Table(name = "addresses")
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Address extends Auditable<String> {

	@Id
	@Column(name = "id", updatable = false, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "email", unique = true, nullable = false)
	private String email;
	
	@Column(name = "mobile_phone_number", unique = true, nullable = false)
	private String mobileNumber;
	
	@Column(name = "address_type", nullable = false)
	private AddressType addressType; 
	
	@Column(name = "contact_person", nullable = false)
	private String contactPerson;
	
	@ManyToOne
	@JoinColumn(name = "country_id", nullable = false)
	private Country country;
	
	@Column(name = "zip_code")
	private String zipCode;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "postal_address")
	private String postalAddress;
	
	@Column(name = "physical_address")
	private String physicalAddress;
	
	@Column(name = "street")
	private String street;
	
	@Column(name = "building")
	private String building;

}
