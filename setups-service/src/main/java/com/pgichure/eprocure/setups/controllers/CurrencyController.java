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

import com.pgichure.eprocure.setups.dtos.CurrencyDto;
import com.pgichure.eprocure.setups.services.CurrencyServiceI;

import lombok.RequiredArgsConstructor;

/**
 * The Currency controller
 * @author pgichure
 *
 */
@RestController
@RequestMapping(value = "/currencies")
@RequiredArgsConstructor
public class CurrencyController {
	
	private final CurrencyServiceI service;
	
	@PostMapping
	public ResponseEntity<CurrencyDto> save(@RequestBody CurrencyDto currency){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(currency));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CurrencyDto> find(@PathVariable("id") Long id) throws Exception{
		return ResponseEntity.status(HttpStatus.FOUND).body(service.findById(id));
	}
	
	@GetMapping
	public ResponseEntity<List<CurrencyDto>> get(@RequestParam Integer page, @RequestParam Integer size,@RequestParam String sortDir, @RequestParam String sort){
		return ResponseEntity.ok().body(service.findAll(page, size, sortDir, sort));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<CurrencyDto> delete(
			@PathVariable("id") Long id) throws Exception{
		CurrencyDto currency = service.delete(id);
		return ResponseEntity.ok().body(currency);
	}

	@PutMapping("/{id}")
	public ResponseEntity<CurrencyDto> update(@PathVariable("id") Long id,
			@RequestBody CurrencyDto currency){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.update(id, currency));
	}
	
}
