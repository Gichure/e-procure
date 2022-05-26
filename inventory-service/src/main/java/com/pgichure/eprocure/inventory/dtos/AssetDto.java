/**
 * 
 */
package com.pgichure.eprocure.inventory.dtos;

import java.io.Serializable;

import com.pgichure.eprocure.inventory.enums.UnitOfMeasure;

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
public class AssetDto implements Serializable{

	private Long id;
  
	private AssetCategoryDto category;
	
	private UnitOfMeasure uom;
	
	private BigDecimal units;
	
	private String name;
  
	private String code;
	
	private Long categoryId;
	
	private Long companyId;
  
}
