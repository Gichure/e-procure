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

import com.pgichure.eprocure.setups.dtos.CompanyGroupDto;
import com.pgichure.eprocure.setups.services.CompanyGroupServiceI;

import lombok.RequiredArgsConstructor;

/**
 * The Company controller
 * @author pgichure
 *
 */
@RestController
@RequestMapping(value = "/company-groups")
@RequiredArgsConstructor
public class CompanyGroupController {
	
	private final CompanyGroupServiceI service;
	
	@PostMapping
	public ResponseEntity<CompanyGroupDto> save(@RequestBody CompanyGroupDto group){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(group));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CompanyGroupDto> find(@PathVariable("id") Long id) throws Exception{
		return ResponseEntity.status(HttpStatus.FOUND).body(service.findById(id));
	}
	
	@GetMapping
	public ResponseEntity<List<CompanyGroupDto>> get(@RequestParam Integer page, @RequestParam Integer size,@RequestParam String sortDir, @RequestParam String sort){
		return ResponseEntity.ok().body(service.findAll(page, size, sortDir, sort));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<CompanyGroupDto> delete(
			@PathVariable("id") Long id) throws Exception{
		CompanyGroupDto group = service.delete(id);
		return ResponseEntity.ok().body(group);
	}

	@PutMapping("/{id}")
	public ResponseEntity<CompanyGroupDto> update(@PathVariable("id") Long id,
			@RequestBody CompanyGroupDto group){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.update(id, group));
	}
	
}
