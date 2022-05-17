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

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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
	@ApiOperation(value = "Save an address" ,notes = "Returns the object created.", response = AddressDto.class)
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "Successfully created the record"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})
	public ResponseEntity<AddressDto> save(@RequestBody AddressDto address){
		return ResponseEntity.status(HttpStatus.CREATED).body(addressService.save(address));
	}
	
	@GetMapping("/{id}")
	@ApiOperation(value = "Get an Address by ID", response = AddressDto.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully retrieved the resource"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})
	public ResponseEntity<AddressDto> find(@PathVariable("id") Long id) throws Exception{
		return ResponseEntity.status(HttpStatus.FOUND).body(addressService.findById(id));
	}
	
	@GetMapping
	@ApiOperation(value = "View a list of addresses", response = List.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})
	public ResponseEntity<List<AddressDto>> get(@RequestParam Integer page, @RequestParam Integer size,@RequestParam String sortDir, @RequestParam String sort){
		return ResponseEntity.ok().body(addressService.findAll(page, size, sortDir, sort));
	}
	
	@DeleteMapping("/{id}")
	@ApiOperation(value = "Delete an address by ID", response = AddressDto.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully deleted the address"),
			@ApiResponse(code = 401, message = "You are not authorized to delete the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})
	public ResponseEntity<AddressDto> delete(
			@ApiParam(value = "The ID of the address to delete", required = true)
			@PathVariable("id") Long id) throws Exception{
		AddressDto address = addressService.delete(id);
		return ResponseEntity.ok().body(address);
	}

	@PutMapping("/{id}")
	@ApiOperation(value = "Update an address" ,notes = "Returns the updated address object created.", response = AddressDto.class)
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "Successfully updated the address"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})
	public ResponseEntity<AddressDto> update(
			@ApiParam(value = "The ID of the address to delete", required = true) Long id,
			@ApiParam(value = "Address details to be updated in database table", required = true)
			@RequestBody AddressDto address){
		return ResponseEntity.status(HttpStatus.CREATED).body(addressService.update(id, address));
	}
	
}
