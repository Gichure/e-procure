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

import org.springframework.data.repository.NoRepositoryBean;

import com.pgichure.eprocure.employees.enums.EmployementType;

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
@Table(name = "product_categories")
@Entity
public class ProductCategory extends Auditable<String>{

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
    
}
