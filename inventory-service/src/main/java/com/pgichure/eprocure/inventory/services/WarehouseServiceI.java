/**
 * 
 */
package com.pgichure.eprocure.inventory.services;

import java.util.List;

import com.pgichure.eprocure.employees.dtos.WarehouseDto;

/**
 * The Warehouse service interface
 * @author pgichure
 *
 */
public interface WarehouseServiceI{
  
    public WarehouseDto save(WarehouseDto warehouseDto);
  
    public WarehouseDto findById(Long id) throws Exception;
  
    public WarehouseDto update(Long id, WarehouseDto assetDto);
  
    public List<WarehouseDto> findAllByCompanyId(Long companyId, int page, int size, String sortDir, String sort);
  
    public List<WarehouseDto> findAll(int page, int size, String sortDir, String sort);
  
    public WarehouseDto delete(Long id) throws Exception;
  
}
