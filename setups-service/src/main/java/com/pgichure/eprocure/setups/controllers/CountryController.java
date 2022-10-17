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

import com.pgichure.eprocure.setups.dtos.CountryDto;
import com.pgichure.eprocure.setups.services.CountryServiceI;

import lombok.RequiredArgsConstructor;

/**
 * The Country controller
 * @author pgichure
 *
 */
@RestController
@RequestMapping(value = "/countries")
@RequiredArgsConstructor
public class CountryController {
	
	private final CountryServiceI service;
	
	@PostMapping
	public ResponseEntity<CountryDto> save(@RequestBody CountryDto country){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(country));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CountryDto> find(@PathVariable("id") Long id) throws Exception{
		return ResponseEntity.status(HttpStatus.FOUND).body(service.findById(id));
	}
	
	@GetMapping
	public ResponseEntity<List<CountryDto>> get(@RequestParam Integer page, @RequestParam Integer size,@RequestParam String sortDir, @RequestParam String sort){
		return ResponseEntity.ok().body(service.findAll(page, size, sortDir, sort));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<CountryDto> delete(
			@PathVariable("id") Long id) throws Exception{
		CountryDto country = service.delete(id);
		return ResponseEntity.ok().body(country);
	}

	@PutMapping("/{id}")
	public ResponseEntity<CountryDto> update(@PathVariable("id") Long id,
			@RequestBody CountryDto country){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.update(id, country));
	}
	
}
