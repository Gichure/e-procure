/**
 * 
 */
package com.pgichure.eprocure.inventory.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pgichure.eprocure.inventory.models.Warehouse;

/**
 * @author pgichure
 *
 */
public interface WarehouseRepository extends JpaRepository<Warehouse, Long> {
  
    public List<Warehouse> findAllByCompanyId(Long companyId);
  
}
