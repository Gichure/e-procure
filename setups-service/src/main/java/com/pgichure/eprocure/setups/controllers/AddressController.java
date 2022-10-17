/**
 * 
 */
package com.pgichure.eprocure.setups.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pgichure.eprocure.setups.dtos.AddressDto;
import com.pgichure.eprocure.setups.services.AddressServiceI;

import lombok.RequiredArgsConstructor;

/**
 * The Address controller
 * @author pgichure
 *
 */
@RestController
@RequestMapping(value = "/addresses")
@RequiredArgsConstructor
public class AddressController {
	
	private final AddressServiceI addressService;
	
	@PostMapping
	
	public ResponseEntity<AddressDto> save(@RequestBody AddressDto address){
		return ResponseEntity.status(HttpStatus.CREATED).body(addressService.save(address));
	}
	
	@GetMapping("/{id}")
	
	public ResponseEntity<AddressDto> find(@PathVariable("id") Long id) throws Exception{
		return ResponseEntity.status(HttpStatus.FOUND).body(addressService.findById(id));
	}
	
	@GetMapping
	
	public ResponseEntity<List<AddressDto>> get(@RequestParam Integer page, @RequestParam Integer size,@RequestParam String sortDir, @RequestParam String sort){
		return ResponseEntity.ok().body(addressService.findAll(page, size, sortDir, sort));
	}
	
	@DeleteMapping("/{id}")
	
	public ResponseEntity<AddressDto> delete(
			@PathVariable("id") Long id) throws Exception{
		AddressDto address = addressService.delete(id);
		return ResponseEntity.ok().body(address);
	}

	@PutMapping("/{id}")
	public ResponseEntity<AddressDto> update(
			@PathVariable("id") Long id,
			@RequestBody AddressDto address){
		return ResponseEntity.status(HttpStatus.CREATED).body(addressService.update(id, address));
	}
	
}
