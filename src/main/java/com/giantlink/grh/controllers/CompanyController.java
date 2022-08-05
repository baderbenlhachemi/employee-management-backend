package com.giantlink.grh.controllers;

import java.util.List;

import com.giantlink.grh.dto.request.CompanyRequest;
import com.giantlink.grh.dto.response.CompanyResponse;
import com.giantlink.grh.exceptions.AlreadyExistsException;
import com.giantlink.grh.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.giantlink.grh.services.CompanyService;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/company")
public class CompanyController {

	private final CompanyService companyService;

	@Autowired
	public CompanyController(CompanyService companyService) {
		this.companyService = companyService;
	}

	@GetMapping("")
	public ResponseEntity<List<CompanyResponse>> get() throws NotFoundException {
		return new ResponseEntity<List<CompanyResponse>>(companyService.get(), HttpStatus.OK);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<CompanyResponse> get(@PathVariable Integer id) throws NotFoundException {
		return new ResponseEntity<CompanyResponse>(companyService.get(id), HttpStatus.OK);
	}

	@GetMapping("/getname/{name}")
	public ResponseEntity<CompanyResponse> getByName(@PathVariable String name) throws NotFoundException {
		return new ResponseEntity<CompanyResponse>(companyService.getByName(name), HttpStatus.OK);
	}

	@PostMapping("/add")
	public ResponseEntity<CompanyResponse> add(@RequestBody @Valid CompanyRequest companyRequest) throws AlreadyExistsException {
		return new ResponseEntity<CompanyResponse>(companyService.add(companyRequest), HttpStatus.CREATED);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<CompanyResponse> update(@PathVariable Integer id, @RequestBody @Valid CompanyRequest companyRequest) throws AlreadyExistsException, NotFoundException {
		return new ResponseEntity<CompanyResponse>(companyService.update(id,companyRequest), HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable Integer id) throws NotFoundException {
		companyService.delete(id);
	}


}
