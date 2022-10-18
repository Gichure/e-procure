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
import javax.persistence.Transient;

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
	
	@Transient
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id", updatable = false, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "effective_from_date", updatable = false, nullable = false)
	private ZonedDateTime effectiveFromDdate;
	
	@Column(name = "effective_to_date", nullable = true)
	private ZonedDateTime effectiveToDate;
	
	@ManyToOne
	@JoinColumn(name = "base_crrency_id", nullable = false)
	private Currency baseCurrency;
	
	@ManyToOne
	@JoinColumn(name = "target_currency_id", nullable = false)
	private Currency  targetCurrency;
	
	@ManyToOne
	@JoinColumn(name = "company_id", nullable = false)
	private Company  company;
	
	@Column(name = "rate", nullable = false)
	private BigDecimal  rate;
}
