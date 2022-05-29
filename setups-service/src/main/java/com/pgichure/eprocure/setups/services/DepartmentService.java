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

import com.pgichure.eprocure.setups.dtos.DepartmentDto;
import com.pgichure.eprocure.setups.models.Department;
import com.pgichure.eprocure.setups.repositories.AddressRepository;
import com.pgichure.eprocure.setups.repositories.DepartmentRepository;

import lombok.RequiredArgsConstructor;

/**
 * @author pgichure
 *
 */
@Service
@RequiredArgsConstructor
public class DepartmentService implements DepartmentServiceI{
	
	private final DepartmentRepository departmentRepository;
	
	private final ModelMapper modelMapper;

	@Override
	public DepartmentDto save(DepartmentDto addressDto) {
		
		Department department = modelMapper.map(addressDto, Department.class);
		department = this.departmentRepository.save(department);
		return modelMapper.map(department, DepartmentDto.class);
		
	}

	@Override
	public DepartmentDto findById(Long departmentId) throws Exception {
		Department department = departmentRepository.findById(departmentId).orElseThrow(() -> new Exception("Department not found - " + departmentId));
		return modelMapper.map(department, DepartmentDto.class);
	}

	@Override
	public DepartmentDto update(Long departmentId, DepartmentDto addressDto) {
		
		if(!Objects.equals(departmentId, addressDto.getId())){
            throw new IllegalArgumentException("IDs don't match");
        }
		Department department = modelMapper.map(addressDto, Department.class);
		
		department = this.departmentRepository.save(department);
		return modelMapper.map(department, DepartmentDto.class);
	}


	@Override
	public List<DepartmentDto> findAll(int page, int size, String sortDir, String sort) {
		PageRequest pageRequest = PageRequest.of(page, size, null,/* Sort.Direction.fromString(sortDir)*/sort);
		List<Department> departments = departmentRepository.findAll(pageRequest).getContent();
		return departments.stream().map(department -> modelMapper.map(department, DepartmentDto.class))
				.collect(Collectors.toList());
	}

	@Override
	public DepartmentDto delete(Long departmentId) throws Exception {
		Department department = departmentRepository.findById(departmentId).orElseThrow(() -> new Exception("Department not found - " + departmentId));
		departmentRepository.delete(department);
		return modelMapper.map(department, DepartmentDto.class);
	}
	
}
