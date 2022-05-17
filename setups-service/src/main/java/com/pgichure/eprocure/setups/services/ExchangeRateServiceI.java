/**
 * 
 */
package com.pgichure.eprocure.setups.services;

import com.pgichure.eprocure.setups.dtos.ExchangeRateDto;

/**
 * The Company service interface
 * @author pgichure
 *
 */
public interface ExchangeRateServiceI{
  
    public ExchangeRateDto save(ExchangeRateDto exchangeRateDto);
  
    public ExchangeRateDto findById(Long id);
  
    public ExchangeRateDto update(Long id, ExchangeRateDto exchangeRateDto);
  
    public List<ExchangeRateDto> findAll();
  
    public ExchangeRateDto delete(Long id);
  
}
