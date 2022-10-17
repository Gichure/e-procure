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

import com.pgichure.eprocure.setups.dtos.DepartmentDto;
import com.pgichure.eprocure.setups.services.DepartmentServiceI;

import lombok.RequiredArgsConstructor;

/**
 * The Department controller
 * @author pgichure
 *
 */
@RestController
@RequestMapping(value = "/departments")
@RequiredArgsConstructor
public class DepartmentController {
	
	private final DepartmentServiceI service;
	
	@PostMapping
	public ResponseEntity<DepartmentDto> save(@RequestBody DepartmentDto department){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(department));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<DepartmentDto> find(@PathVariable("id") Long id) throws Exception{
		return ResponseEntity.status(HttpStatus.FOUND).body(service.findById(id));
	}
	
	@GetMapping
	public ResponseEntity<List<DepartmentDto>> get(@RequestParam Integer page, @RequestParam Integer size,@RequestParam String sortDir, @RequestParam String sort){
		return ResponseEntity.ok().body(service.findAll(page, size, sortDir, sort));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<DepartmentDto> delete(
			@PathVariable("id") Long id) throws Exception{
		DepartmentDto department = service.delete(id);
		return ResponseEntity.ok().body(department);
	}

	@PutMapping("/{id}")
	public ResponseEntity<DepartmentDto> update(@PathVariable("id") Long id,
			@RequestBody DepartmentDto department){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.update(id, department));
	}
	
}
