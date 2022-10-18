/**
 * 
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
@Schema(name="Country", description="Country Details")
public class CountryDto implements Serializable{

	@Schema(name="id", description="The unique identifier")
	private Long id;
	
	@Schema(name="name", description="The country name", required = true)
  	private String name;
  
	@Schema(name="code", description="The country code", required = true)
	private String code;
	
	@Schema(name="flag", description="The country flag image", example = "ke.png")
	private String flag;

}
