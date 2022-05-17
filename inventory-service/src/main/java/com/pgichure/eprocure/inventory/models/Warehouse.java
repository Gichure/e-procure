/**
 * 
 */
package com.pgichure.eprocure.inventory.models;

import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.pgichure.eprocure.inventory.enums.OpenStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author pgichure
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "warehouses")
@Entity
public class Warehouse extends Auditable<String>{

  @Id
	@Column(name = "id", updatable = false, nullable = false)
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long id;
  
	@Column(name = "company_id", nullable = false)
	private Long companyId;
  
  @Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "code", nullable = false)
	private String code;
  
  @Column(name = "status", nullable = false)
  @Enumerated(EnumType.STRING)
  private OpenStatus status;
  
  @Column(name = "location", nullable = false)
  private String location;
  
  @Column(name = "latitude", nullable = false)
  private BigDecimal latitude;
  
  @Column(name = "longitude", nullable = false)
  private BigDecimal longitude;
  
}
