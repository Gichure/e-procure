/**
 * 
 */
package com.pgichure.eprocure.setups.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pgichure.eprocure.setups.models.CompanyGroup;
/**
 * @author pgichure
 *
 */
public interface CompanyGroupRepository extends JpaRepository<CompanyGroup, Long> {
  
	public List<CompanyGroup> findAllByCode(String code);
	
}
