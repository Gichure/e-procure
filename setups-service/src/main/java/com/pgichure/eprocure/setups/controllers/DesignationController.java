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

import com.pgichure.eprocure.setups.dtos.DesignationDto;
import com.pgichure.eprocure.setups.services.DesignationServiceI;

import lombok.RequiredArgsConstructor;

/**
 * The Designation controller
 * @author pgichure
 *
 */
@RestController
@RequestMapping(value = "/designations")
@RequiredArgsConstructor
public class DesignationController {
	
	private final DesignationServiceI service;
	
	@PostMapping
	public ResponseEntity<DesignationDto> save(@RequestBody DesignationDto designation){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(designation));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<DesignationDto> find(@PathVariable("id") Long id) throws Exception{
		return ResponseEntity.status(HttpStatus.FOUND).body(service.findById(id));
	}
	
	@GetMapping
	public ResponseEntity<List<DesignationDto>> get(@RequestParam Integer page, @RequestParam Integer size,@RequestParam String sortDir, @RequestParam String sort){
		return ResponseEntity.ok().body(service.findAll(page, size, sortDir, sort));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<DesignationDto> delete(
			@PathVariable("id") Long id) throws Exception{
		DesignationDto designation = service.delete(id);
		return ResponseEntity.ok().body(designation);
	}

	@PutMapping("/{id}")
	public ResponseEntity<DesignationDto> update(@PathVariable("id") Long id,
			@RequestBody DesignationDto designation){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.update(id, designation));
	}
	
}
