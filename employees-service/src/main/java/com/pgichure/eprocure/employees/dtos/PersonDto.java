/**
 * 
 */
package com.pgichure.eprocure.employees.dtos;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Date;

import com.pgichure.eprocure.employees.enums.Gender;

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
public class PersonDto implements Serializable{

	private Long id;
  
	private String firstName;
	
	private String surname;
  
	private Gender gender;
	
	private Date dob;
	
	private Long addressId;
	
	private Long groupId;
	
	private Long companyId;
  
}
