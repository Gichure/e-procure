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

import com.pgichure.eprocure.setups.dtos.CompanyDto;
import com.pgichure.eprocure.setups.services.CompanyServiceI;

import lombok.RequiredArgsConstructor;

/**
 * The Company controller
 * @author pgichure
 *
 */
@RestController
@RequestMapping(value = "/companies")
@RequiredArgsConstructor
public class CompanyController {
	
	private final CompanyServiceI service;
	
	@PostMapping
	public ResponseEntity<CompanyDto> save(@RequestBody CompanyDto company){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(company));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CompanyDto> find(@PathVariable("id") Long id) throws Exception{
		return ResponseEntity.status(HttpStatus.FOUND).body(service.findById(id));
	}
	
	@GetMapping
	public ResponseEntity<List<CompanyDto>> get(@RequestParam Integer page, @RequestParam Integer size,@RequestParam String sortDir, @RequestParam String sort){
		return ResponseEntity.ok().body(service.findAll(page, size, sortDir, sort));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<CompanyDto> delete(
			@PathVariable("id") Long id) throws Exception{
		CompanyDto company = service.delete(id);
		return ResponseEntity.ok().body(company);
	}

	@PutMapping("/{id}")
	public ResponseEntity<CompanyDto> update(@PathVariable("id") Long id,
			@RequestBody CompanyDto company){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.update(id, company));
	}
	
}
