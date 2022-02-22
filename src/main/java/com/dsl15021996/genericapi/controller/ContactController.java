package com.dsl15021996.genericapi.controller;

import java.util.Date;
import java.util.List;

import com.dsl15021996.genericapi.model.Contact;
import com.dsl15021996.genericapi.model.Status;
import com.dsl15021996.genericapi.service.ContactService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/contact")
public class ContactController {

    @Autowired
    ContactService service;

	@Value("${spring.datasource.url}")
	private String database;

    @ApiOperation(value = "Traz um contato pelo id")
	@GetMapping(value = "{id}", produces = { "application/json" })
	public ResponseEntity<Contact> findById(@PathVariable(value = "id") Long id) throws Exception {
		return ResponseEntity.ok(service.findByIdContact(id));
	}
	
	@ApiOperation(value = "Traz uma Lista de Contatos")
	@GetMapping(produces = { "application/json" })
	public ResponseEntity<List<Contact>> findAll() {
		return ResponseEntity.ok(service.findAllContact());
	}
	

	@ApiOperation(value = "Cria um contato")
	@PostMapping(consumes = { "application/json" }, produces = { "application/json" })
	public ResponseEntity<Contact> createBrand(@RequestBody Contact contact) throws Exception {
		contact.setCreated(new Date());
		return ResponseEntity.ok(service.createContact(contact));
	}

	@ApiOperation(value = "Status da API")
	@GetMapping(value = "status", produces = { "application/json" })
	public ResponseEntity<Status> getStatus() throws Exception {
		final String baseUrl = 
		ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString();

		return ResponseEntity.ok(new Status(baseUrl, database, new Date()));
	}
    
}
