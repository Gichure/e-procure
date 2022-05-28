/**
 * 
 */
package com.pgichure.eprocure.setups.services;

import java.util.List;

import com.pgichure.eprocure.setups.dtos.CountryDto;

/**
 * The Country service interface
 * @author pgichure
 *
 */
public interface CountryServiceI{
  
    public CountryDto save(CountryDto countryDto);
  
    public CountryDto findById(Long id) throws Exception;
  
    public CountryDto update(Long id, CountryDto countryDto);
  
    public List<CountryDto> findAll(int page, int size, String sortDir, String sort);
  
    public CountryDto delete(Long id) throws Exception;
  
}
