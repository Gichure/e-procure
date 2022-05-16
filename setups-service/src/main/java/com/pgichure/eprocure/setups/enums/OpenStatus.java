/**
 * 
 */
package com.pgichure.eprocure.setups.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author pgichure
 *
 */
@Getter
@AllArgsConstructor
public enum OpenStatus {
	
	OPEN("Open"),CLOSED("Closed");
	
	private String name;

}
