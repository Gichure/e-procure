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

import com.pgichure.eprocure.setups.dtos.ExchangeRateDto;
import com.pgichure.eprocure.setups.models.ExchangeRate;
import com.pgichure.eprocure.setups.repositories.ExchangeRateRepository;

import lombok.RequiredArgsConstructor;

/**
 * @author pgichure
 *
 */
@Service
@RequiredArgsConstructor
public class ExchangeRateService implements ExchangeRateServiceI{
	
	private final ExchangeRateRepository repository;
	
	private final ModelMapper modelMapper;

	@Override
	public ExchangeRateDto save(ExchangeRateDto rateDto) {
		
		ExchangeRate rate = modelMapper.map(rateDto, ExchangeRate.class);
		rate = this.repository.save(rate);
		return modelMapper.map(rate, ExchangeRateDto.class);
		
	}

	@Override
	public ExchangeRateDto findById(Long rateId) throws Exception {
		ExchangeRate rate = repository.findById(rateId).orElseThrow(() -> new Exception("ExchangeRate not found - " + rateId));
		return modelMapper.map(rate, ExchangeRateDto.class);
	}

	@Override
	public ExchangeRateDto update(Long rateId, ExchangeRateDto rateDto) {
		
		if(!Objects.equals(rateId, rateDto.getId())){
            throw new IllegalArgumentException("IDs don't match");
        }
		ExchangeRate rate = modelMapper.map(rateDto, ExchangeRate.class);
		
		rate = this.repository.save(rate);
		return modelMapper.map(rate, ExchangeRateDto.class);
	}


	@Override
	public List<ExchangeRateDto> findAll(int page, int size, String sortDir, String sort) {
		PageRequest pageRequest = PageRequest.of(page, size, null,/* Sort.Direction.fromString(sortDir)*/sort);
		List<ExchangeRate> addresses = repository.findAll(pageRequest).getContent();
		return addresses.stream().map(rate -> modelMapper.map(rate, ExchangeRateDto.class))
				.collect(Collectors.toList());
	}

	@Override
	public ExchangeRateDto delete(Long rateId) throws Exception {
		ExchangeRate rate = repository.findById(rateId).orElseThrow(() -> new Exception("ExchangeRate not found - " + rateId));
		repository.delete(rate);
		return modelMapper.map(rate, ExchangeRateDto.class);
	}
	
}
