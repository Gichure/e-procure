/**
 * 
 */
package com.pgichure.eprocure.setups.services;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.pgichure.eprocure.setups.dtos.CompanyGroupDto;
import com.pgichure.eprocure.setups.models.CompanyGroup;
import com.pgichure.eprocure.setups.repositories.CompanyGroupRepository;

import lombok.RequiredArgsConstructor;

/**
 * @author pgichure
 *
 */
@Service
@RequiredArgsConstructor
public class CompanyGroupService implements CompanyGroupServiceI{
	
	private final CompanyGroupRepository companyGroupRepository;
	
	private final ModelMapper modelMapper;

	@Override
	public CompanyGroupDto save(CompanyGroupDto companyGroupDto) {
		
		CompanyGroup group = modelMapper.map(companyGroupDto, CompanyGroup.class);
		group = this.companyGroupRepository.save(group);
		return modelMapper.map(group, CompanyGroupDto.class);
		
	}

	@Override
	public CompanyGroupDto findById(Long addressId) throws Exception {
		CompanyGroup group = companyGroupRepository.findById(addressId).orElseThrow(() -> new Exception("Company Group not found - " + addressId));
		return modelMapper.map(group, CompanyGroupDto.class);
	}

	@Override
	public CompanyGroupDto update(Long groupId, CompanyGroupDto companyGroupDto) {
		
		if(!Objects.equals(groupId, companyGroupDto.getId())){
            throw new IllegalArgumentException("IDs don't match");
        }
		CompanyGroup group = modelMapper.map(companyGroupDto, CompanyGroup.class);
		
		group = this.companyGroupRepository.save(group);
		return modelMapper.map(group, CompanyGroupDto.class);
	}

	@Override
	public List<CompanyGroupDto> findAll(int page, int size, String sortDir, String sort) {
		PageRequest pageRequest = PageRequest.of(page, size, null,/* Sort.Direction.fromString(sortDir)*/sort);
		List<CompanyGroup> groups = companyGroupRepository.findAll(pageRequest).getContent();
		return groups.stream().map(group -> modelMapper.map(group, CompanyGroupDto.class))
				.collect(Collectors.toList());
	}

	@Override
	public CompanyGroupDto delete(Long groupId) throws Exception {
		CompanyGroup group = companyGroupRepository.findById(groupId).orElseThrow(() -> new Exception("Company Group not found - " + groupId));
		companyGroupRepository.delete(group);
		return modelMapper.map(group, CompanyGroupDto.class);
	}
	
}
