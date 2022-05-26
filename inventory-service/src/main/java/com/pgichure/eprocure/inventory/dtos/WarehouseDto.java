/**
 * 
 */
package com.pgichure.eprocure.inventory.dtos;

import java.io.Serializable;

import com.pgichure.eprocure.inventory.enums.OpenStatus;

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
public class WarehouseDto implements Serializable{

	private Long id;
    
	private Long companyId;
  
	private String name;
	
	private String code;
  
  private OpenStatus status;
  
  private String location;
  
  private BigDecimal latitude;
  
  private BigDecimal longitude;
  
}
