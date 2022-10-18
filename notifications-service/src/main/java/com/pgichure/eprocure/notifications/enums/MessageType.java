/**
 * 
 */
package com.pgichure.eprocure.notifications.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author pgichure
 *
 */
@Getter
@AllArgsConstructor
public enum MessageType {

	EMAIL,
	SMS,
	INTERNAL;
	
}
