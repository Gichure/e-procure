/**
 * 
 */
package com.pgichure.eprocure.setups.services;

import java.util.List;

import com.pgichure.eprocure.setups.dtos.ExchangeRateDto;

/**
 * The Exhange rate service interface
 * @author pgichure
 *
 */
public interface ExchangeRateServiceI{
  
    public ExchangeRateDto save(ExchangeRateDto exchangeRateDto);
  
    public ExchangeRateDto findById(Long id);
  
    public ExchangeRateDto update(Long id, ExchangeRateDto exchangeRateDto);
  
    public List<ExchangeRateDto> findAll(int page, int size, String sortDir, String sort);
  
    public ExchangeRateDto delete(Long id);
  
}
