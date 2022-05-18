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

import com.pgichure.eprocure.setups.dtos.AddressDto;
import com.pgichure.eprocure.setups.models.Address;
import com.pgichure.eprocure.setups.repositories.AddressRepository;

import lombok.RequiredArgsConstructor;

/**
 * @author pgichure
 *
 */
@Service
@RequiredArgsConstructor
public class AddressService implements AddressServiceI{
	
	private final AddressRepository addressRepository;
	
	private final ModelMapper modelMapper;

	@Override
	public AddressDto save(AddressDto addressDto) {
		
		Address address = modelMapper.map(addressDto, Address.class);
		address = this.addressRepository.save(address);
		return modelMapper.map(address, AddressDto.class);
		
	}

	@Override
	public AddressDto findById(Long addressId) throws Exception {
		Address address = addressRepository.findById(addressId).orElseThrow(() -> new Exception("Address not found - " + addressId));
		return modelMapper.map(address, AddressDto.class);
	}

	@Override
	public AddressDto update(Long addressId, AddressDto addressDto) {
		
		if(!Objects.equals(addressId, addressDto.getId())){
            throw new IllegalArgumentException("IDs don't match");
        }
		Address address = modelMapper.map(addressDto, Address.class);
		
		address = this.addressRepository.save(address);
		return modelMapper.map(address, AddressDto.class);
	}

	@Override
	public List<AddressDto> findAllByEmaill(String email) {
		List<Address> addresses = addressRepository.findAllByEmaill(email);
		return addresses.stream().map(address -> modelMapper.map(address, AddressDto.class))
				.collect(Collectors.toList());
	}

	@Override
	public List<AddressDto> findAll(int page, int size, String sortDir, String sort) {
		PageRequest pageRequest = PageRequest.of(page, size, null,/* Sort.Direction.fromString(sortDir)*/sort);
		List<Address> addresses = addressRepository.findAll(pageRequest).getContent();
		return addresses.stream().map(address -> modelMapper.map(address, AddressDto.class))
				.collect(Collectors.toList());
	}

	@Override
	public AddressDto delete(Long addressId) throws Exception {
		Address address = addressRepository.findById(addressId).orElseThrow(() -> new Exception("Address not found - " + addressId));
		addressRepository.delete(address);
		return modelMapper.map(address, AddressDto.class);
	}
	
}
