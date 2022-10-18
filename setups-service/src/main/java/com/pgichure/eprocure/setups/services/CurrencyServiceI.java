/**
 * 
 */
package com.pgichure.eprocure.setups.services;

import java.util.List;

import com.pgichure.eprocure.setups.dtos.CurrencyDto;

/**
 * The Currency service interface
 * @author pgichure
 *
 */
public interface CurrencyServiceI{
  
    public CurrencyDto save(CurrencyDto currencyDto);
  
    public CurrencyDto findById(Long id) throws Exception;
  
    public CurrencyDto update(Long id, CurrencyDto currencyDto);
  
    public List<CurrencyDto> findAll(int page, int size, String sortDir, String sort);
  
    public CurrencyDto delete(Long id) throws Exception;
    
    public List<CurrencyDto> findAllByCode(String code);
  
}
