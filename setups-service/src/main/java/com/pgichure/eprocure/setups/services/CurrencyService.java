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

import com.pgichure.eprocure.setups.dtos.CurrencyDto;
import com.pgichure.eprocure.setups.models.Currency;
import com.pgichure.eprocure.setups.repositories.CountryRepository;
import com.pgichure.eprocure.setups.repositories.CurrencyRepository;

import lombok.RequiredArgsConstructor;

/**
 * @author pgichure
 *
 */
@Service
@RequiredArgsConstructor
public class CurrencyService implements CurrencyServiceI{
	
	private final CurrencyRepository repository;
	
	private final ModelMapper modelMapper;

	@Override
	public CurrencyDto save(CurrencyDto currencyDto) {
		
		Currency country = modelMapper.map(currencyDto, Currency.class);
		country = this.repository.save(country);
		return modelMapper.map(country, CurrencyDto.class);
		
	}

	@Override
	public CurrencyDto findById(Long currencyId) throws Exception {
		Currency country = repository.findById(currencyId).orElseThrow(() -> new Exception("Currency not found - " + currencyId));
		return modelMapper.map(country, CurrencyDto.class);
	}

	@Override
	public CurrencyDto update(Long currencyId, CurrencyDto currencyDto) {
		
		if(!Objects.equals(currencyId, currencyDto.getId())){
            throw new IllegalArgumentException("IDs don't match");
        }
		Currency country = modelMapper.map(currencyDto, Currency.class);
		
		country = this.repository.save(country);
		return modelMapper.map(country, CurrencyDto.class);
	}


	@Override
	public List<CurrencyDto> findAll(int page, int size, String sortDir, String sort) {
		PageRequest pageRequest = PageRequest.of(page, size, null,/* Sort.Direction.fromString(sortDir)*/sort);
		List<Currency> addresses = repository.findAll(pageRequest).getContent();
		return addresses.stream().map(country -> modelMapper.map(country, CurrencyDto.class))
				.collect(Collectors.toList());
	}

	@Override
	public CurrencyDto delete(Long currencyId) throws Exception {
		Currency country = repository.findById(currencyId).orElseThrow(() -> new Exception("Currency not found - " + currencyId));
		repository.delete(country);
		return modelMapper.map(country, CurrencyDto.class);
	}
	
}
