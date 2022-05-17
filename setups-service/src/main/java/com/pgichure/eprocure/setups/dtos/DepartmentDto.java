 * 
 */
package com.pgichure.eprocure.setups.dtos;

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
public class DepartmentDto extends Auditable<String>{

	private Long id;
  
	private String name;
	
	private String code;
  
}
