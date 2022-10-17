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
import com.pgichure.eprocure.setups.services.AddressServiceI;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;

/**
 * The Address controller
 * @author pgichure
 *
 */
@RestController
@RequestMapping(value = "/addresses")
@RequiredArgsConstructor
public class AddressController {
	
	private final AddressServiceI addressService;
	
	@PostMapping
	@Operation(summary = "Create an address")
	@ApiResponses(value = { 
	  @ApiResponse(responseCode = "201", description = "Created the address", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = AddressDto.class)) }),
	  @ApiResponse(responseCode = "400", description = "Invalid details supplied", content = @Content),
	  @ApiResponse(responseCode = "404", description = "Endpoint not found", content = @Content) })
	public ResponseEntity<AddressDto> save(@Parameter(description = "The address details") @RequestBody AddressDto address){
		return ResponseEntity.status(HttpStatus.CREATED).body(addressService.save(address));
	}
	
	@GetMapping("/{id}")
	@Operation(summary = "Find address by ID")
	@ApiResponses(value = { 
	  @ApiResponse(responseCode = "200", description = "Found the address", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = AddressDto.class)) }),
	  @ApiResponse(responseCode = "400", description = "Invalid ID supplied", content = @Content),
	  @ApiResponse(responseCode = "404", description = "Address not found", content = @Content) })
	public ResponseEntity<AddressDto> find(@Parameter(description = "The ID to search details for")@PathVariable("id") Long id) throws Exception{
		return ResponseEntity.status(HttpStatus.FOUND).body(addressService.findById(id));
	}
	
	@GetMapping
	@Operation(summary = "Find addresses")
	@ApiResponses(value = { 
	  @ApiResponse(responseCode = "200", description = "Found the addresses", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = List.class)) }),
	  @ApiResponse(responseCode = "400", description = "Invalid ID supplied", content = @Content),
	  @ApiResponse(responseCode = "404", description = "Addresses not found", content = @Content) })
	public ResponseEntity<List<AddressDto>> get(@RequestParam Integer page, @RequestParam Integer size, @RequestParam String sortDir, @RequestParam String sort){
		return ResponseEntity.ok().body(addressService.findAll(page, size, sortDir, sort));
	}
	
	@DeleteMapping("/{id}")
	@Operation(summary = "Delete address by ID")
	@ApiResponses(value = { 
	  @ApiResponse(responseCode = "200", description = "Deleted the address", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = AddressDto.class)) }),
	  @ApiResponse(responseCode = "400", description = "Invalid ID supplied", content = @Content),
	  @ApiResponse(responseCode = "404", description = "Address not found", content = @Content) })
	public ResponseEntity<AddressDto> delete(
			@PathVariable("id") Long id) throws Exception{
		AddressDto address = addressService.delete(id);
		return ResponseEntity.ok().body(address);
	}

	@PutMapping("/{id}")
	@Operation(summary = "Update address by ID")
	@ApiResponses(value = { 
	  @ApiResponse(responseCode = "201", description = "Updated the address", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = AddressDto.class)) }),
	  @ApiResponse(responseCode = "400", description = "Invalid ID supplied", content = @Content),
	  @ApiResponse(responseCode = "404", description = "Address not found", content = @Content) })
	public ResponseEntity<AddressDto> update(
			@PathVariable("id") Long id,
			@RequestBody AddressDto address){
		return ResponseEntity.status(HttpStatus.CREATED).body(addressService.update(id, address));
	}
	
}
