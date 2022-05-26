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

import com.pgichure.eprocure.inventory.enums.UnitOfMeasure;

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
@Table(name = "employees")
@Entity
public class Asset extends Auditable<String>{

	@Id
	@Column(name = "id", updatable = false, nullable = false)
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "category_id", nullable = false)
	private AssetCategory category;
	
	@Column(name = "uom", nullable = false)
	@Enumerated(EnumType.STRING)
	private UnitOfMeasure uom;
	
	@Column(name = "units", nullable = false)
	private BigDecimal units;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "code", nullable = false)
	private String code;
  
}
