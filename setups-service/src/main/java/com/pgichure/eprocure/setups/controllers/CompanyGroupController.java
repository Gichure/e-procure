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
@RequestMapping(value = "/company-groups")
@RequiredArgsConstructor
public class CompanyGroupController {
	
	private final CompanyGroupServiceI service;
	
	@PostMapping
	@ApiOperation(value = "Save company group" ,notes = "Returns the object created.", response = CompanyGroupDto.class)
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "Successfully created the record"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})
	public ResponseEntity<CompanyGroupDto> save(@RequestBody CompanyGroupDto group){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(group));
	}
	
	@GetMapping("/{id}")
	@ApiOperation(value = "Get an Company Group by ID", response = CompanyGroupDto.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully retrieved the resource"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})
	public ResponseEntity<CompanyGroupDto> find(@PathVariable("id") Long id) throws Exception{
		return ResponseEntity.status(HttpStatus.FOUND).body(service.findById(id));
	}
	
	@GetMapping
	@ApiOperation(value = "View a list of company groups", response = List.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})
	public ResponseEntity<List<CompanyGroupDto>> get(@RequestParam Integer page, @RequestParam Integer size,@RequestParam String sortDir, @RequestParam String sort){
		return ResponseEntity.ok().body(service.findAll(page, size, sortDir, sort));
	}
	
	@DeleteMapping("/{id}")
	@ApiOperation(value = "Delete an company by group ID", response = CompanyGroupDto.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully deleted the company group"),
			@ApiResponse(code = 401, message = "You are not authorized to delete the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})
	public ResponseEntity<CompanyGroupDto> delete(
			@ApiParam(value = "The ID of the company group to delete", required = true)
			@PathVariable("id") Long id) throws Exception{
		CompanyGroupDto group = service.delete(id);
		return ResponseEntity.ok().body(group);
	}

	@PutMapping("/{id}")
	@ApiOperation(value = "Update an company group" ,notes = "Returns the updated company group object created.", response = CompanyGroupDto.class)
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "Successfully updated the company group"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})
	public ResponseEntity<CompanyGroupDto> update(
			@ApiParam(value = "The ID of the company to delete", required = true) Long id,
			@ApiParam(value = "Company Group details to be updated in database table", required = true)
			@RequestBody CompanyGroupDto group){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.update(id, group));
	}
	
}
