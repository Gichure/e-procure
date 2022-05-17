/**
 * 
 */
package com.pgichure.eprocure.setups.repositories;

import com.pgichure.eprocure.setups.models.Address;

/**
 * @author pgichure
 *
 */

@Repository 
public interface AddressRepository extends JpaRepository<Address, Long> {
  
    public List<Address> findAllByEmaill(String email);
  
}
