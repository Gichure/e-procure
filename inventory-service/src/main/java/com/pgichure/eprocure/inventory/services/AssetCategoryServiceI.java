/**
 * 
 */
package com.pgichure.eprocure.inventory.services;

import java.util.List;

import com.pgichure.eprocure.employees.dtos.AssetCategoryDto;

/**
 * The Asset Category service interface
 * @author pgichure
 *
 */
public interface AssetCategoryServiceI{
  
    public AssetCategoryDto save(AssetCategoryDto assetCategoryDto);
  
    public AssetCategoryDto findById(Long assetCategoryId) throws Exception;
  
    public AssetCategoryDto update(Long assetCategoryId, AssetCategoryDto assetCategoryDto);
  
    public List<AssetCategoryDto> findAllByCompanyId(Long companyId, int page, int size, String sortDir, String sort);
  
    public List<AssetCategoryDto> findAll(int page, int size, String sortDir, String sort);
  
    public AssetCategoryDto delete(Long assetCategoryId) throws Exception;
  
}
