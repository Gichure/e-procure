/**
 * 
 */
package com.pgichure.eprocure.setups.services;

import java.util.List;

import com.pgichure.eprocure.setups.dtos.AddressDto;

/**
 * The Address service interface
 * @author pgichure
 *
 */
public interface AddressServiceI{
  
    public AddressDto save(AddressDto addressDto);
  
    public AddressDto findById(Long addressId) throws Exception;
  
    public AddressDto update(Long addressId, AddressDto addressDto);
  
    public List<AddressDto> findAllByEmaill(String email);
  
    public List<AddressDto> findAll(int page, int size, String sortDir, String sort);
  
    public AddressDto delete(Long addressId) throws Exception;
  
}
