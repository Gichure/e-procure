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
@Schema(name="Currency", description="Currency Details")
public class CurrencyDto implements Serializable{

	@Schema(name="id", description="The unique identifier")
	private Long id;
	
	@Schema(name="name", description="The currency name", required = true)
  	private String name;
  
	@Schema(name="code", description="The currency code", required = true)
	private String code;

}
