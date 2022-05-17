/**
 * 
 */
package com.pgichure.eprocure.setups.services;

import com.pgichure.eprocure.setups.dtos.AddressDto;

/**
 * @author pgichure
 *
 */
public interface AddressServiceI{
  
    public AddressDto save(AddressDto addressDto);
  
    public AddressDto findById(Long addressId);
  
    public AddressDto update(Long addressId, AddressDto addressDto);
  
    public List<AddressDto> findAllByEmaill(String email);
  
    public List<AddressDto> findAll();
  
    public AddressDto delete(Long addressId);
  
}
