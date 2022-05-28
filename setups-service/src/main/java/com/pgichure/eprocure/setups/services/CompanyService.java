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

import com.pgichure.eprocure.setups.dtos.CompanyDto;
import com.pgichure.eprocure.setups.models.Company;
import com.pgichure.eprocure.setups.repositories.CompanyRepository;

import lombok.RequiredArgsConstructor;

/**
 * @author pgichure
 *
 */
@Service
@RequiredArgsConstructor
public class CompanyService implements CompanyServiceI{
	
	private final CompanyRepository companyRepository;
	
	private final ModelMapper modelMapper;

	@Override
	public CompanyDto save(CompanyDto companyDto) {
		
		Company company = modelMapper.map(companyDto, Company.class);
		company = companyRepository.save(company);
		return modelMapper.map(company, CompanyDto.class);
		
	}

	@Override
	public CompanyDto findById(Long companyId) throws Exception {
		Company company = companyRepository.findById(companyId).orElseThrow(() -> new Exception("Company not found - " + companyId));
		return modelMapper.map(company, CompanyDto.class);
	}

	@Override
	public CompanyDto update(Long companyId, CompanyDto companyDto) {
		
		if(!Objects.equals(companyId, companyDto.getId())){
            throw new IllegalArgumentException("IDs don't match");
        }
		Company company = modelMapper.map(companyDto, Company.class);
		
		company = companyRepository.save(company);
		return modelMapper.map(company, CompanyDto.class);
	}

	@Override
	public List<CompanyDto> findAll(int page, int size, String sortDir, String sort) {
		PageRequest pageRequest = PageRequest.of(page, size, null,/* Sort.Direction.fromString(sortDir)*/sort);
		List<Company> companies = companyRepository.findAll(pageRequest).getContent();
		return companies.stream().map(company -> modelMapper.map(company, CompanyDto.class))
				.collect(Collectors.toList());
	}

	@Override
	public CompanyDto delete(Long companyId) throws Exception {
		Company group = companyRepository.findById(companyId).orElseThrow(() -> new Exception("Company not found - " + companyId));
		companyRepository.delete(group);
		return modelMapper.map(group, CompanyDto.class);
	}
	
}
