/**
 * 
 */
package com.pgichure.eprocure.inventory.dtos;

import java.io.Serializable;

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
public class AssetCategoryDto implements Serializable{

	private Long id;
  
	private Long companyId;
  
	private String name;
	
	private String code;
  
}
