/**
 * 
 */
package com.pgichure.eprocure.employees.controllers;

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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

/**
 * @author pgichure
 *
 */
@RestController
@RequestMapping(value = "/employees")
@RequiredArgsConstructor
@Tag(name = "Employee", description = "The Employee API")
public class EmployeeController {

	@PostMapping
	@Operation(summary = "Create an employee")
	@ApiResponses(value = { 
	  @ApiResponse(responseCode = "201", description = "Created the employee", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = Object.class)) }),
	  @ApiResponse(responseCode = "400", description = "Invalid details supplied", content = @Content),
	  @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content),
	  @ApiResponse(responseCode = "403", description = "Forbidden", content = @Content),
	  @ApiResponse(responseCode = "404", description = "Endpoint not found", content = @Content) })
	public ResponseEntity<?> save(@Parameter(description = "The employee details") @RequestBody Object employee){
		return ResponseEntity.status(HttpStatus.CREATED).body(employee);
	}
	
	@GetMapping("/{id}")
	@Operation(summary = "Find employee by ID")
	@ApiResponses(value = { 
	  @ApiResponse(responseCode = "200", description = "Found the employee", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = Object.class)) }),
	  @ApiResponse(responseCode = "400", description = "Invalid ID supplied", content = @Content),
	  @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content),
	  @ApiResponse(responseCode = "403", description = "Forbidden", content = @Content),
	  @ApiResponse(responseCode = "404", description = "Address not found", content = @Content) })
	public ResponseEntity<?> find(@Parameter(description = "The ID to search details for") @PathVariable("id") Long id) throws Exception{
		return ResponseEntity.status(HttpStatus.FOUND).body(Object.class);
	}
	
	@GetMapping
	@Operation(summary = "Find employees")
	@ApiResponses(value = { 
	  @ApiResponse(responseCode = "200", description = "Found the employees", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = List.class)) }),
	  @ApiResponse(responseCode = "400", description = "Invalid request", content = @Content),
	  @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content),
	  @ApiResponse(responseCode = "403", description = "Forbidden", content = @Content),
	  @ApiResponse(responseCode = "404", description = "Records not found", content = @Content) })
	public ResponseEntity<List<?>> get(@RequestParam Integer page, @RequestParam Integer size, @RequestParam String sortDir, @RequestParam String sort){
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/{id}")
	@Operation(summary = "Delete employee by ID")
	@ApiResponses(value = { 
	  @ApiResponse(responseCode = "200", description = "Deleted the record", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = Object.class)) }),
	  @ApiResponse(responseCode = "400", description = "Invalid ID supplied", content = @Content),
	  @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content),
	  @ApiResponse(responseCode = "403", description = "Forbidden", content = @Content),
	  @ApiResponse(responseCode = "404", description = "Record not found", content = @Content) })
	public ResponseEntity<?> delete(
			@PathVariable("id") Long id) throws Exception{
		return ResponseEntity.ok().body(id);
	}

	@PutMapping("/{id}")
	@Operation(summary = "Update employee by ID")
	@ApiResponses(value = { 
	  @ApiResponse(responseCode = "201", description = "Updated the record", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = Object.class)) }),
	  @ApiResponse(responseCode = "400", description = "Invalid request", content = @Content),
	  @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content),
	  @ApiResponse(responseCode = "403", description = "Forbidden", content = @Content),
	  @ApiResponse(responseCode = "404", description = "Record not found", content = @Content) })
	public ResponseEntity<?> update(
			@Parameter(description = "The ID to update") @PathVariable("id") Long id,
			@Parameter(description = "The employee details") @RequestBody Object employee){
		return ResponseEntity.status(HttpStatus.CREATED).body(employee);
	}
	
}
