/**
 * 
 */
package com.pgichure.eprocure.inventory.services;

import java.util.List;

import com.pgichure.eprocure.employees.dtos.AssetDto;

/**
 * The Asset service interface
 * @author pgichure
 *
 */
public interface AssetServiceI{
  
    public AssetDto save(AssetDto assetDto);
  
    public AssetDto findById(Long assetId) throws Exception;
  
    public AssetDto update(Long assetId, AssetDto assetDto);
  
    public List<AssetDto> findAllByCompanyId(Long companyId, int page, int size, String sortDir, String sort);
  
    public List<AssetDto> findAll(int page, int size, String sortDir, String sort);
  
    public AssetDto delete(Long assetId) throws Exception;
  
}
