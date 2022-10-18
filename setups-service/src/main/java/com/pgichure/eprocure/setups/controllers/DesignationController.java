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

import com.pgichure.eprocure.setups.dtos.AddressDto;
import com.pgichure.eprocure.setups.dtos.CompanyDto;
import com.pgichure.eprocure.setups.dtos.DesignationDto;
import com.pgichure.eprocure.setups.services.DesignationServiceI;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

/**
 * The Designation controller
 * @author pgichure
 *
 */
@RestController
@RequestMapping(value = "/designations")
@RequiredArgsConstructor
@Tag(name = "Designation", description = "The Designation API")
public class DesignationController {
	
	private final DesignationServiceI service;
	
	@PostMapping
	@Operation(summary = "Create a designation")
	@ApiResponses(value = { 
	  @ApiResponse(responseCode = "201", description = "Created the designation", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = DesignationDto.class)) }),
	  @ApiResponse(responseCode = "400", description = "Invalid details supplied", content = @Content),
	  @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content),
	  @ApiResponse(responseCode = "403", description = "Forbidden", content = @Content),
	  @ApiResponse(responseCode = "404", description = "Endpoint not found", content = @Content) })
	public ResponseEntity<DesignationDto> save(@Parameter(description = "The designation details") @RequestBody DesignationDto designation){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(designation));
	}
	
	@GetMapping("/{id}")
	@Operation(summary = "Find designation by ID")
	@ApiResponses(value = { 
	  @ApiResponse(responseCode = "200", description = "Found the record", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = DesignationDto.class)) }),
	  @ApiResponse(responseCode = "400", description = "Invalid request", content = @Content),
	  @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content),
	  @ApiResponse(responseCode = "403", description = "Forbidden", content = @Content),
	  @ApiResponse(responseCode = "404", description = "Record not found", content = @Content) })
	public ResponseEntity<DesignationDto> find(@Parameter(description = "The ID to search") @PathVariable("id") Long id) throws Exception{
		return ResponseEntity.status(HttpStatus.FOUND).body(service.findById(id));
	}
	
	@GetMapping
	@Operation(summary = "Find designations")
	@ApiResponses(value = { 
	  @ApiResponse(responseCode = "200", description = "Found the records", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = List.class)) }),
	  @ApiResponse(responseCode = "400", description = "Invalid request", content = @Content),
	  @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content),
	  @ApiResponse(responseCode = "403", description = "Forbidden", content = @Content),
	  @ApiResponse(responseCode = "404", description = "Records not found", content = @Content) })
	public ResponseEntity<List<DesignationDto>> get(@RequestParam Integer page, @RequestParam Integer size,@RequestParam String sortDir, @RequestParam String sort){
		return ResponseEntity.ok().body(service.findAll(page, size, sortDir, sort));
	}
	
	@DeleteMapping("/{id}")
	@Operation(summary = "Delete designation by ID")
	@ApiResponses(value = { 
	  @ApiResponse(responseCode = "200", description = "Deleted the record", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = DesignationDto.class)) }),
	  @ApiResponse(responseCode = "400", description = "Invalid request", content = @Content),
	  @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content),
	  @ApiResponse(responseCode = "403", description = "Forbidden", content = @Content),
	  @ApiResponse(responseCode = "404", description = "Record not found", content = @Content) })
	public ResponseEntity<DesignationDto> delete(
			@Parameter(description = "The ID to delete") @PathVariable("id") Long id) throws Exception{
		DesignationDto designation = service.delete(id);
		return ResponseEntity.ok().body(designation);
	}

	@PutMapping("/{id}")
	@Operation(summary = "Update designation by ID")
	@ApiResponses(value = { 
	  @ApiResponse(responseCode = "201", description = "Updated the record", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = DesignationDto.class)) }),
	  @ApiResponse(responseCode = "400", description = "Invalid request", content = @Content),
	  @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content),
	  @ApiResponse(responseCode = "403", description = "Forbidden", content = @Content),
	  @ApiResponse(responseCode = "404", description = "Record not found", content = @Content) })
	public ResponseEntity<DesignationDto> update(@Parameter(description = "The ID to update") @PathVariable("id") Long id,
			@Parameter(description = "The designation details") @RequestBody DesignationDto designation){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.update(id, designation));
	}
	
}
