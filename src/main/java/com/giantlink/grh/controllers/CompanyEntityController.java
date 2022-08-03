package com.giantlink.grh.controllers;

import com.giantlink.grh.dto.request.CompanyEntityRequest;
import com.giantlink.grh.dto.response.CompanyEntityResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.giantlink.grh.entities.CompanyEntity;
import com.giantlink.grh.services.CompanyEntityService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/company/entity")
public class CompanyEntityController {

	private final CompanyEntityService companyEntityService;

	@Autowired
	public CompanyEntityController(CompanyEntityService companyEntityService) {
		this.companyEntityService = companyEntityService;
	}

	@GetMapping("")
	public ResponseEntity<List<CompanyEntityResponse>> get() {
		return new ResponseEntity<List<CompanyEntityResponse>>(companyEntityService.get(), HttpStatus.OK);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<CompanyEntityResponse> get(@PathVariable Integer id) {
		return new ResponseEntity<CompanyEntityResponse>(companyEntityService.get(id), HttpStatus.OK);
	}

	@PostMapping("/add")
	public ResponseEntity<CompanyEntityResponse> add(@RequestBody CompanyEntityRequest companyEntityRequest) {
		return new ResponseEntity<CompanyEntityResponse>(companyEntityService.add(companyEntityRequest), HttpStatus.CREATED);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<CompanyEntityResponse> update(@PathVariable Integer id, @RequestBody CompanyEntityRequest companyEntityRequest) {
		return new ResponseEntity<CompanyEntityResponse>(companyEntityService.update(id,companyEntityRequest), HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable Integer id) {
		companyEntityService.delete(id);
	}
}
