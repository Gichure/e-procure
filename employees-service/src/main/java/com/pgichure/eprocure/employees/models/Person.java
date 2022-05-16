/**
 * 
 */
package com.pgichure.eprocure.employees.models;

import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.pgichure.eprocure.employees.enums.Gender;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author pgichure
 *
 */
@Entity
@Table(name = "persons")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person extends Auditable<String>{
	
	@Id
	@Column(name = "id", updatable = false, nullable = false)
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long id;
	
	@Column(name = "first_name", nullable = false)
	private String firstName;
	
	@Column(name = "surname", nullable = false)
	private String surname;
	
	@Column(name = "gender", nullable = false)
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	@Column(name = "dob", nullable = false)
	private ZonedDateTime dob;
	
	@Column(name = "address_id", nullable = false)
	private Long addressId;
	
	@Column(name = "group_id", nullable = false)
	private Long groupId;
	
	@Column(name = "company_id", nullable = false)
	private Long companyId;

}
