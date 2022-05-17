/**
 * 
 */
package com.pgichure.eprocure.setups.services;

import com.pgichure.eprocure.setups.dtos.CountryDto;

/**
 * The Company service interface
 * @author pgichure
 *
 */
public interface CountryServiceI{
  
    public CountryDto save(CountryDto countryDto);
  
    public CountryDto findById(Long id);
  
    public CountryDto update(Long id, CountryDto countryDto);
  
    public List<CountryDto> findAll();
  
    public CountryDto delete(Long id);
  
}
