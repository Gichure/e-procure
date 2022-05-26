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

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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
	@ApiOperation(value = "Save a department" ,notes = "Returns the object created.", response = ExchangeRateDto.class)
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "Successfully created the record"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})
	public ResponseEntity<ExchangeRateDto> save(@RequestBody ExchangeRateDto rate){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(rate));
	}
	
	@GetMapping("/{id}")
	@ApiOperation(value = "Get an rate by ID", response = ExchangeRateDto.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully retrieved the resource"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})
	public ResponseEntity<ExchangeRateDto> find(@PathVariable("id") Long id) throws Exception{
		return ResponseEntity.status(HttpStatus.FOUND).body(service.findById(id));
	}
	
	@GetMapping
	@ApiOperation(value = "View a list of exchange rates", response = List.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})
	public ResponseEntity<List<ExchangeRateDto>> get(@RequestParam Integer page, @RequestParam Integer size,@RequestParam String sortDir, @RequestParam String sort){
		return ResponseEntity.ok().body(service.findAll(page, size, sortDir, sort));
	}
	
	@DeleteMapping("/{id}")
	@ApiOperation(value = "Delete an exchange rate by ID", response = ExchangeRateDto.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully deleted the object"),
			@ApiResponse(code = 401, message = "You are not authorized to delete the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})
	public ResponseEntity<ExchangeRateDto> delete(
			@ApiParam(value = "The ID of the object to delete", required = true)
			@PathVariable("id") Long id) throws Exception{
		ExchangeRateDto rate = service.delete(id);
		return ResponseEntity.ok().body(rate);
	}

	@PutMapping("/{id}")
	@ApiOperation(value = "Update a rate" ,notes = "Returns the updated rate object created.", response = ExchangeRateDto.class)
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "Successfully updated the object"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})
	public ResponseEntity<ExchangeRateDto> update(
			@ApiParam(value = "The ID of the object to delete", required = true) Long id,
			@ApiParam(value = "Object details to be updated in database table", required = true)
			@RequestBody ExchangeRateDto rate){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.update(id, rate));
	}
	
}
