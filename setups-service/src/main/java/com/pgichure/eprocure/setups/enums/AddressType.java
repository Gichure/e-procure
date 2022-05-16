/**
 * 
 */
package com.pgichure.eprocure.setups.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * The address type
 * @author pgichure
 *
 */
@Getter
@AllArgsConstructor
public enum AddressType {

	ORDINARY("Ordinary Address"),
	EMERGENCY("Emergency Address");
	
	private String name;
}
