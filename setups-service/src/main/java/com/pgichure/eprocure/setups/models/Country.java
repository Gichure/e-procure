/**
 * 
 */
package com.pgichure.eprocure.setups.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.pgichure.eprocure.setups.enums.OpenStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author pgichure
 *
 */
@Data
@Table(name = "countries")
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Country extends Auditable<String>{

	@Id
	@Column(name = "id", updatable = false, nullable = false)
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long id;
	
	@Column(name = "name", unique = true, nullable = false)
	private String name;
	
	@Column(name = "code", unique = true, nullable = false)
	private String code;
	
	@Column(name = "flag")
	private String flag;

}