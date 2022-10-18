/**
 * 
 */
package com.pgichure.eprocure.notifications.controllers;

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

import com.pgichure.eprocure.notifications.dtos.SmtpSettingsDto;
import com.pgichure.eprocure.notifications.dtos.SmtpSettingsDto;
import com.pgichure.eprocure.notifications.services.MessageBatchServiceI;
import com.pgichure.eprocure.notifications.services.MessageServiceI;
import com.pgichure.eprocure.notifications.services.SmtpSettingsServiceI;

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
@RequestMapping(value = "/smtp-settings")
@RequiredArgsConstructor
@Tag(name = "SMTP Settings", description = "The SMTP Settings API")
public class SmtpSettingsController {

	private final SmtpSettingsServiceI service;

	@PostMapping
	@Operation(summary = "Create a Smtp Settings")
	@ApiResponses(value = { 
	  @ApiResponse(responseCode = "201", description = "Created the Smtp Settings", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = SmtpSettingsDto.class)) }),
	  @ApiResponse(responseCode = "400", description = "Invalid details supplied", content = @Content),
	  @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content),
	  @ApiResponse(responseCode = "403", description = "Forbidden", content = @Content),
	  @ApiResponse(responseCode = "404", description = "Endpoint not found", content = @Content) })
	public ResponseEntity<?> save(@Parameter(description = "The message settings details") @RequestBody SmtpSettingsDto settings){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(settings));
	}
	
	@GetMapping("/{id}")
	@Operation(summary = "Find smtp settings by ID")
	@ApiResponses(value = { 
	  @ApiResponse(responseCode = "200", description = "Found the smtp settings", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = SmtpSettingsDto.class)) }),
	  @ApiResponse(responseCode = "400", description = "Invalid ID supplied", content = @Content),
	  @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content),
	  @ApiResponse(responseCode = "403", description = "Forbidden", content = @Content),
	  @ApiResponse(responseCode = "404", description = "Address not found", content = @Content) })
	public ResponseEntity<SmtpSettingsDto> find(@Parameter(description = "The ID to search details for") @PathVariable("id") Long id) throws Exception{
		return ResponseEntity.status(HttpStatus.FOUND).body(service.findById(id));
	}
	
	@GetMapping
	@Operation(summary = "Find smtp settings")
	@ApiResponses(value = { 
	  @ApiResponse(responseCode = "200", description = "Found the smtp settings", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = List.class)) }),
	  @ApiResponse(responseCode = "400", description = "Invalid request", content = @Content),
	  @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content),
	  @ApiResponse(responseCode = "403", description = "Forbidden", content = @Content),
	  @ApiResponse(responseCode = "404", description = "Records not found", content = @Content) })
	public ResponseEntity<List<SmtpSettingsDto>> get(@RequestParam Integer page, @RequestParam Integer size, @RequestParam String sortDir, @RequestParam String sort){
		return ResponseEntity.ok().body(service.findAll(page, size, sortDir, sort));
	}
	
	@DeleteMapping("/{id}")
	@Operation(summary = "Delete smtp settings by ID")
	@ApiResponses(value = { 
	  @ApiResponse(responseCode = "200", description = "Deleted the record", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = SmtpSettingsDto.class)) }),
	  @ApiResponse(responseCode = "400", description = "Invalid ID supplied", content = @Content),
	  @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content),
	  @ApiResponse(responseCode = "403", description = "Forbidden", content = @Content),
	  @ApiResponse(responseCode = "404", description = "Record not found", content = @Content) })
	public ResponseEntity<SmtpSettingsDto> delete(
			@PathVariable("id") Long id) throws Exception{
		return ResponseEntity.ok().body(service.delete(id));
	}

	@PutMapping("/{id}")
	@Operation(summary = "Update smtp settings by ID")
	@ApiResponses(value = { 
	  @ApiResponse(responseCode = "201", description = "Updated the record", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = SmtpSettingsDto.class)) }),
	  @ApiResponse(responseCode = "400", description = "Invalid request", content = @Content),
	  @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content),
	  @ApiResponse(responseCode = "403", description = "Forbidden", content = @Content),
	  @ApiResponse(responseCode = "404", description = "Record not found", content = @Content) })
	public ResponseEntity<?> update(
			@Parameter(description = "The ID to update") @PathVariable("id") Long id,
			@Parameter(description = "The smtp settings details") @RequestBody SmtpSettingsDto settings){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.update(id, settings));
	}
	
}
