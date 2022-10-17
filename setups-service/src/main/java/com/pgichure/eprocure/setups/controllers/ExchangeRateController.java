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

import com.pgichure.eprocure.setups.dtos.ExchangeRateDto;
import com.pgichure.eprocure.setups.services.ExchangeRateServiceI;

import lombok.RequiredArgsConstructor;

/**
 * The Exchange Rate controller
 * @author pgichure
 *
 */
@RestController
@RequestMapping(value = "/exchange-rates")
@RequiredArgsConstructor
public class ExchangeRateController {
	
	private final ExchangeRateServiceI service;
	
	@PostMapping
	public ResponseEntity<ExchangeRateDto> save(@RequestBody ExchangeRateDto rate){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(rate));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ExchangeRateDto> find(@PathVariable("id") Long id) throws Exception{
		return ResponseEntity.status(HttpStatus.FOUND).body(service.findById(id));
	}
	
	@GetMapping
	public ResponseEntity<List<ExchangeRateDto>> get(@RequestParam Integer page, @RequestParam Integer size,@RequestParam String sortDir, @RequestParam String sort){
		return ResponseEntity.ok().body(service.findAll(page, size, sortDir, sort));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ExchangeRateDto> delete(
			@PathVariable("id") Long id) throws Exception{
		ExchangeRateDto rate = service.delete(id);
		return ResponseEntity.ok().body(rate);
	}

	@PutMapping("/{id}")
	public ResponseEntity<ExchangeRateDto> update(@PathVariable("id") Long id,
			@RequestBody ExchangeRateDto rate){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.update(id, rate));
	}
	
}
