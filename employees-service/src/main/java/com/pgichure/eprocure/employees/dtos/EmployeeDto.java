/**
 * 
 */
package com.pgichure.eprocure.employees.dtos;

import java.io.Serializable;

import com.pgichure.eprocure.employees.enums.EmployementType;

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
public class EmployeeDto implements Serializable{

	private Long id;
  
	private PersonDto person;
	
	private EmployeeDto supervisor;
	
	private EmployementType employementType;
	
	private ZonedDateTime employementDate;
	
	private ZonedDateTime exitDate;
	
	private Long departmentId;
	
	private Long designationId;
	
	private Long companyId;
  
}
