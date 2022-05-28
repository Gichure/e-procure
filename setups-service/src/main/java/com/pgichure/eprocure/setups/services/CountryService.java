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

import com.pgichure.eprocure.setups.dtos.CountryDto;
import com.pgichure.eprocure.setups.models.Country;
import com.pgichure.eprocure.setups.repositories.CountryRepository;

import lombok.RequiredArgsConstructor;

/**
 * @author pgichure
 *
 */
@Service
@RequiredArgsConstructor
public class CountryService implements CountryServiceI{
	
	private final CountryRepository repository;
	
	private final ModelMapper modelMapper;

	@Override
	public CountryDto save(CountryDto countryDto) {
		
		Country country = modelMapper.map(countryDto, Country.class);
		country = this.repository.save(country);
		return modelMapper.map(country, CountryDto.class);
		
	}

	@Override
	public CountryDto findById(Long countryId) throws Exception {
		Country country = repository.findById(countryId).orElseThrow(() -> new Exception("Country not found - " + countryId));
		return modelMapper.map(country, CountryDto.class);
	}

	@Override
	public CountryDto update(Long countryId, CountryDto countryDto) {
		
		if(!Objects.equals(countryId, countryDto.getId())){
            throw new IllegalArgumentException("IDs don't match");
        }
		Country country = modelMapper.map(countryDto, Country.class);
		
		country = this.repository.save(country);
		return modelMapper.map(country, CountryDto.class);
	}


	@Override
	public List<CountryDto> findAll(int page, int size, String sortDir, String sort) {
		PageRequest pageRequest = PageRequest.of(page, size, null,/* Sort.Direction.fromString(sortDir)*/sort);
		List<Country> addresses = repository.findAll(pageRequest).getContent();
		return addresses.stream().map(country -> modelMapper.map(country, CountryDto.class))
				.collect(Collectors.toList());
	}

	@Override
	public CountryDto delete(Long countryId) throws Exception {
		Country country = repository.findById(countryId).orElseThrow(() -> new Exception("Country not found - " + countryId));
		repository.delete(country);
		return modelMapper.map(country, CountryDto.class);
	}
	
}
