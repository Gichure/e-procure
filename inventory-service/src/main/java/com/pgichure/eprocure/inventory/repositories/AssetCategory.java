/**
 * 
 */
package com.pgichure.eprocure.inventory.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pgichure.eprocure.inventory.models.Asset;
/**
 * @author pgichure
 *
 */
public interface AssetRepository extends JpaRepository<Asset, Long> {
  
    public List<Asset> findAllByCompanyId(Long companyId);
  
    public List<Asset> findAllByCategoryId(Long categoryId);
  
}
