/**
 * 
 */
package com.pgichure.eprocure.setups.models;

import java.time.ZonedDateTime;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.pgichure.eprocure.setups.enums.OpenStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * The company group
 * @author pgichure
 *
 */
@Data
@Table(name = "company_groups")
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CompanyGroup extends Auditable<String>{
	
	@Id
	@Column(name = "id", updatable = false, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name", unique = true, nullable = false)
	private String name;
	
	@Column(name = "code", unique = true, nullable = false)
	private String code;
	
	@ManyToOne
	@JoinColumn(name = "address_id", nullable = false)
	private Address address;
	
	@Column(name = "tax_identification_number", unique = true, nullable = true)
	private String taxIdentificationNumber;
	
	@Column(name = "vat_number", unique = true, nullable = true)
	private String vatNumber;
	
	@ManyToOne
	@JoinColumn(name = "country_id", nullable = false)
	private Country country;
	
	@ManyToOne
	@JoinColumn(name = "currency_id", nullable = false)
	private Currency currency;
	
	@Column(name = "status", nullable = false)
	@Enumerated(EnumType.STRING)
	private OpenStatus status;

}
