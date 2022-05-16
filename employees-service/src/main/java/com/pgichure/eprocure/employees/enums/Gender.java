/**
 * 
 */
package com.pgichure.eprocure.employees.enums;


import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Hp
 *
 */
@Getter
@AllArgsConstructor
public enum Gender {

	MALE("Male"),FEMALE("Female"),UN_DISCLOSED("Undislosed"),UNKNOWN("Unkown");
	
	private String name;
}
