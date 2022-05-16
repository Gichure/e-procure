/**
 * 
 */
package com.pgichure.eprocure.setups.models;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "exchange_rates")
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ExchangeRate extends Auditable<String>{

	@Id
	@Column(name = "id", updatable = false, nullable = false)
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long id;
	
	@Column(name = "effective_from_date", updatable = false, nullable = false)
	private ZonedDateTime effective_from_date;
	
	@Column(name = "effective_to_date", nullable = true)
	private ZonedDateTime effective_to_date;
	
	@ManyToOne
	@JoinColumn(name = "base_crrency_id", nullable = false)
	private Currency base_crrency_id;
	
	@ManyToOne
	@JoinColumn(name = "target_currency_id", nullable = false)
	private Currency  target_currency_id;
	
	@ManyToOne
	@JoinColumn(name = "company_id", nullable = false)
	private Company  company_id;
	
	@Column(name = "rate", nullable = false)
	private BigDecimal  rate;
}
