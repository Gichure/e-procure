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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

/**
 * The Department controller
 * @author pgichure
 *
 */
@RestController
@RequestMapping(value = "/departments")
@RequiredArgsConstructor
@Tag(name = "Department", description = "The Department API")
public class DepartmentController {
	
	private final DepartmentServiceI service;
	
	@PostMapping
	@Operation(summary = "Create a department")
	@ApiResponses(value = { 
	  @ApiResponse(responseCode = "201", description = "Created the department", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = DepartmentDto.class)) }),
	  @ApiResponse(responseCode = "400", description = "Invalid details supplied", content = @Content),
	  @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content),
	  @ApiResponse(responseCode = "403", description = "Forbidden", content = @Content),
	  @ApiResponse(responseCode = "404", description = "Endpoint not found", content = @Content) })
	public ResponseEntity<DepartmentDto> save(@Parameter(description = "The department details") @RequestBody DepartmentDto department){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(department));
	}
	
	@GetMapping("/{id}")
	@Operation(summary = "Find department by ID")
	@ApiResponses(value = { 
	  @ApiResponse(responseCode = "200", description = "Found the department", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = DepartmentDto.class)) }),
	  @ApiResponse(responseCode = "400", description = "Invalid ID supplied", content = @Content),
	  @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content),
	  @ApiResponse(responseCode = "403", description = "Forbidden", content = @Content),
	  @ApiResponse(responseCode = "404", description = "Record not found", content = @Content) })
	public ResponseEntity<DepartmentDto> find(@Parameter(description = "The ID to search") @PathVariable("id") Long id) throws Exception{
		return ResponseEntity.status(HttpStatus.FOUND).body(service.findById(id));
	}
	
	@GetMapping
	@Operation(summary = "Find departments")
	@ApiResponses(value = { 
			  @ApiResponse(responseCode = "200", description = "Found the records", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = List.class)) }),
			  @ApiResponse(responseCode = "400", description = "Invalid request", content = @Content),
			  @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content),
			  @ApiResponse(responseCode = "403", description = "Forbidden", content = @Content),
			  @ApiResponse(responseCode = "404", description = "Records not found", content = @Content) })
	public ResponseEntity<List<DepartmentDto>> get(@RequestParam Integer page, @RequestParam Integer size,@RequestParam String sortDir, @RequestParam String sort){
		return ResponseEntity.ok().body(service.findAll(page, size, sortDir, sort));
	}
	
	@DeleteMapping("/{id}")
	@Operation(summary = "Delete department by ID")
	@ApiResponses(value = { 
	  @ApiResponse(responseCode = "200", description = "Deleted the record", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = DepartmentDto.class)) }),
	  @ApiResponse(responseCode = "400", description = "Invalid request", content = @Content),
	  @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content),
	  @ApiResponse(responseCode = "403", description = "Forbidden", content = @Content),
	  @ApiResponse(responseCode = "404", description = "Record not found", content = @Content) })
	public ResponseEntity<DepartmentDto> delete(
			@Parameter(description = "The ID to delete") @PathVariable("id") Long id) throws Exception{
		DepartmentDto department = service.delete(id);
		return ResponseEntity.ok().body(department);
	}

	@PutMapping("/{id}")
	@Operation(summary = "Update department by ID")
	@ApiResponses(value = { 
	  @ApiResponse(responseCode = "201", description = "Updated the record", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = DepartmentDto.class)) }),
	  @ApiResponse(responseCode = "400", description = "Invalid request", content = @Content),
	  @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content),
	  @ApiResponse(responseCode = "403", description = "Forbidden", content = @Content),
	  @ApiResponse(responseCode = "404", description = "Record not found", content = @Content) })
	public ResponseEntity<DepartmentDto> update(@Parameter(description = "The ID to update") @PathVariable("id") Long id,
			@Parameter(description = "The department details") @RequestBody DepartmentDto department){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.update(id, department));
	}
	
}
