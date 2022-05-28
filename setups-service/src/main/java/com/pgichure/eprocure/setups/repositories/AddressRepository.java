/**
 * 
 */
package com.pgichure.eprocure.setups.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pgichure.eprocure.setups.models.Address;
/**
 * @author pgichure
 *
 */
public interface AddressRepository extends JpaRepository<Address, Long> {
  
    public List<Address> findAllByEmail(String email);
  
}
