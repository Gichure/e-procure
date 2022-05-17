/**
 * 
 */
package com.pgichure.eprocure.setups.repositories;

import com.pgichure.eprocure.setups.models.Address;
import org.springframework.data.repository.JpaRepository;
/**
 * @author pgichure
 *
 */
public interface AddressRepository extends JpaRepository<Address, Long> {
  
    public List<Address> findAllByEmaill(String email);
  
}
