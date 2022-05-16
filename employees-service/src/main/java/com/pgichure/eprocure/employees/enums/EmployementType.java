/**
 * 
 */
package com.pgichure.eprocure.employees.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author pgichure
 *
 */
@Getter
@AllArgsConstructor
public enum EmployementType {

	ONBOARDING,
	PROBATION,
	ACTIVE,
	ON_LEAVE,
	ON_NOTICE_OF_EXIT,
	SUSPENDED,
	RETIRED,
	EXITED;
	
}
