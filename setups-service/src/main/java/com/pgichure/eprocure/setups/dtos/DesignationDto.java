 /* 
 */
package com.pgichure.eprocure.setups.dtos;

import java.io.Serializable;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author pgichure
 *
 */
@SuppressWarnings("serial")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Schema(name="Designation", description="Designation Details")
public class DesignationDto implements Serializable{

	@Schema(name="id", description="The unique identifier")
	private Long id;
	
	@Schema(name="name", description="The designation name", required = true)
  	private String name;
  
	@Schema(name="code", description="The designation code", required = true)
	private String code;
  
}
