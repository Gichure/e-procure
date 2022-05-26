/**
 * 
 */
package com.pgichure.eprocure.inventory.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pgichure.eprocure.inventory.models.AssetCategory;
/**
 * @author pgichure
 *
 */
public interface AssetCategoryRepository extends JpaRepository<AssetCategory, Long> {
  
    public List<AssetCategory> findAllByCompanyId(Long companyId);
  
}
