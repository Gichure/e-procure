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

import com.pgichure.eprocure.setups.dtos.DesignationDto;
import com.pgichure.eprocure.setups.models.Designation;
import com.pgichure.eprocure.setups.repositories.DesignationRepository;

import lombok.RequiredArgsConstructor;

/**
 * @author pgichure
 *
 */
@Service
@RequiredArgsConstructor
public class DesignationService implements DesignationServiceI{
	
	private final DesignationRepository repository;
	
	private final ModelMapper modelMapper;

	@Override
	public DesignationDto save(DesignationDto addressDto) {
		
		Designation designation = modelMapper.map(addressDto, Designation.class);
		designation = this.repository.save(designation);
		return modelMapper.map(designation, DesignationDto.class);
		
	}

	@Override
	public DesignationDto findById(Long designationId) throws Exception {
		Designation designation = repository.findById(designationId).orElseThrow(() -> new Exception("Designation not found - " + designationId));
		return modelMapper.map(designation, DesignationDto.class);
	}

	@Override
	public DesignationDto update(Long designationId, DesignationDto addressDto) {
		
		if(!Objects.equals(designationId, addressDto.getId())){
            throw new IllegalArgumentException("IDs don't match");
        }
		Designation designation = modelMapper.map(addressDto, Designation.class);
		
		designation = this.repository.save(designation);
		return modelMapper.map(designation, DesignationDto.class);
	}

	@Override
	public List<DesignationDto> findAll(int page, int size, String sortDir, String sort) {
		PageRequest pageRequest = PageRequest.of(page, size, null,/* Sort.Direction.fromString(sortDir)*/sort);
		List<Designation> addresses = repository.findAll(pageRequest).getContent();
		return addresses.stream().map(designation -> modelMapper.map(designation, DesignationDto.class))
				.collect(Collectors.toList());
	}

	@Override
	public DesignationDto delete(Long designationId) throws Exception {
		Designation designation = repository.findById(designationId).orElseThrow(() -> new Exception("Designation not found - " + designationId));
		repository.delete(designation);
		return modelMapper.map(designation, DesignationDto.class);
	}
	
}
