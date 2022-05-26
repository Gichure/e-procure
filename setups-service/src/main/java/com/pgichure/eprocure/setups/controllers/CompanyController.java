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

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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
	@ApiOperation(value = "Save an address" ,notes = "Returns the object created.", response = CompanyDto.class)
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "Successfully created the record"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})
	public ResponseEntity<CompanyDto> save(@RequestBody CompanyDto company){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(company));
	}
	
	@GetMapping("/{id}")
	@ApiOperation(value = "Get an Company by ID", response = CompanyDto.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully retrieved the resource"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})
	public ResponseEntity<CompanyDto> find(@PathVariable("id") Long id) throws Exception{
		return ResponseEntity.status(HttpStatus.FOUND).body(service.findById(id));
	}
	
	@GetMapping
	@ApiOperation(value = "View a list of companies", response = List.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})
	public ResponseEntity<List<CompanyDto>> get(@RequestParam Integer page, @RequestParam Integer size,@RequestParam String sortDir, @RequestParam String sort){
		return ResponseEntity.ok().body(service.findAll(page, size, sortDir, sort));
	}
	
	@DeleteMapping("/{id}")
	@ApiOperation(value = "Delete an company by ID", response = CompanyDto.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully deleted the company"),
			@ApiResponse(code = 401, message = "You are not authorized to delete the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})
	public ResponseEntity<CompanyDto> delete(
			@ApiParam(value = "The ID of the company to delete", required = true)
			@PathVariable("id") Long id) throws Exception{
		CompanyDto company = service.delete(id);
		return ResponseEntity.ok().body(company);
	}

	@PutMapping("/{id}")
	@ApiOperation(value = "Update an company" ,notes = "Returns the updated company object created.", response = CompanyDto.class)
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "Successfully updated the company"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})
	public ResponseEntity<CompanyDto> update(
			@ApiParam(value = "The ID of the company to delete", required = true) Long id,
			@ApiParam(value = "Address details to be updated in database table", required = true)
			@RequestBody CompanyDto company){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.update(id, company));
	}
	
}
