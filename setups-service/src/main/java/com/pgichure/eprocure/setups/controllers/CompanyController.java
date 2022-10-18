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
import com.pgichure.eprocure.setups.services.CompanyServiceI;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

/**
 * The Company controller
 * @author pgichure
 *
 */
@RestController
@RequestMapping(value = "/companies")
@RequiredArgsConstructor
@Tag(name = "Company", description = "The Company API")
public class CompanyController {
	
	private final CompanyServiceI service;
	
	@PostMapping
	@Operation(summary = "Create a company")
	@ApiResponses(value = { 
	  @ApiResponse(responseCode = "201", description = "Created the company", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = CompanyDto.class)) }),
	  @ApiResponse(responseCode = "400", description = "Invalid details supplied", content = @Content),
	  @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content),
	  @ApiResponse(responseCode = "403", description = "Forbidden", content = @Content),
	  @ApiResponse(responseCode = "404", description = "Endpoint not found", content = @Content) })
	public ResponseEntity<CompanyDto> save(@Parameter(description = "The company details") @RequestBody CompanyDto company){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(company));
	}
	
	@GetMapping("/{id}")
	@Operation(summary = "Find company by ID")
	@ApiResponses(value = { 
	  @ApiResponse(responseCode = "200", description = "Found the record", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = CompanyDto.class)) }),
	  @ApiResponse(responseCode = "400", description = "Invalid ID supplied", content = @Content),
	  @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content),
	  @ApiResponse(responseCode = "403", description = "Forbidden", content = @Content),
	  @ApiResponse(responseCode = "404", description = "Record not found", content = @Content) })
	public ResponseEntity<CompanyDto> find(@Parameter(description = "The ID to search") @PathVariable("id") Long id) throws Exception{
		return ResponseEntity.status(HttpStatus.FOUND).body(service.findById(id));
	}
	
	@GetMapping
	@Operation(summary = "Find companies")
	@ApiResponses(value = { 
			  @ApiResponse(responseCode = "200", description = "Found the records", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = List.class)) }),
			  @ApiResponse(responseCode = "400", description = "Invalid request", content = @Content),
			  @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content),
			  @ApiResponse(responseCode = "403", description = "Forbidden", content = @Content),
			  @ApiResponse(responseCode = "404", description = "Records not found", content = @Content) })
	public ResponseEntity<List<CompanyDto>> get(@RequestParam Integer page, @RequestParam Integer size,@RequestParam String sortDir, @RequestParam String sort){
		return ResponseEntity.ok().body(service.findAll(page, size, sortDir, sort));
	}
	
	@DeleteMapping("/{id}")
	@Operation(summary = "Delete company by ID")
	@ApiResponses(value = { 
	  @ApiResponse(responseCode = "200", description = "Deleted the record", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = CompanyDto.class)) }),
	  @ApiResponse(responseCode = "400", description = "Invalid request", content = @Content),
	  @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content),
	  @ApiResponse(responseCode = "403", description = "Forbidden", content = @Content),
	  @ApiResponse(responseCode = "404", description = "Record not found", content = @Content) })
	public ResponseEntity<CompanyDto> delete(
			@Parameter(description = "The ID to delete") @PathVariable("id") Long id) throws Exception{
		CompanyDto company = service.delete(id);
		return ResponseEntity.ok().body(company);
	}

	@PutMapping("/{id}")
	@Operation(summary = "Update company by ID")
	@ApiResponses(value = { 
	  @ApiResponse(responseCode = "201", description = "Updated the record", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = CompanyDto.class)) }),
	  @ApiResponse(responseCode = "400", description = "Invalid request", content = @Content),
	  @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content),
	  @ApiResponse(responseCode = "403", description = "Forbidden", content = @Content),
	  @ApiResponse(responseCode = "404", description = "Record not found", content = @Content) })
	public ResponseEntity<CompanyDto> update(@Parameter(description = "The ID to update") @PathVariable("id") Long id,
			@Parameter(description = "The company details") @RequestBody CompanyDto company){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.update(id, company));
	}
	
}
