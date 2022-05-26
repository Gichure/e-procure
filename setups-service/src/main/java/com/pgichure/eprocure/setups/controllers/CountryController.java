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
@RequestMapping(value = "/countries")
@RequiredArgsConstructor
public class CompanyController {
	
	private final CountryServiceI service;
	
	@PostMapping
	@ApiOperation(value = "Save a country" ,notes = "Returns the object created.", response = CountryDto.class)
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "Successfully created the record"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})
	public ResponseEntity<CountryDto> save(@RequestBody CountryDto country){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(country));
	}
	
	@GetMapping("/{id}")
	@ApiOperation(value = "Get an Company by ID", response = CountryDto.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully retrieved the resource"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})
	public ResponseEntity<CountryDto> find(@PathVariable("id") Long id) throws Exception{
		return ResponseEntity.status(HttpStatus.FOUND).body(service.findById(id));
	}
	
	@GetMapping
	@ApiOperation(value = "View a list of countries", response = List.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})
	public ResponseEntity<List<CountryDto>> get(@RequestParam Integer page, @RequestParam Integer size,@RequestParam String sortDir, @RequestParam String sort){
		return ResponseEntity.ok().body(service.findAll(page, size, sortDir, sort));
	}
	
	@DeleteMapping("/{id}")
	@ApiOperation(value = "Delete an country by ID", response = CountryDto.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully deleted the country"),
			@ApiResponse(code = 401, message = "You are not authorized to delete the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})
	public ResponseEntity<CountryDto> delete(
			@ApiParam(value = "The ID of the country to delete", required = true)
			@PathVariable("id") Long id) throws Exception{
		CountryDto country = service.delete(id);
		return ResponseEntity.ok().body(country);
	}

	@PutMapping("/{id}")
	@ApiOperation(value = "Update an country" ,notes = "Returns the updated country object created.", response = CountryDto.class)
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "Successfully updated the object"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})
	public ResponseEntity<CompanyDto> update(
			@ApiParam(value = "The ID of the object to delete", required = true) Long id,
			@ApiParam(value = "Object details to be updated in database table", required = true)
			@RequestBody CountryDto country){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.update(id, country));
	}
	
}
