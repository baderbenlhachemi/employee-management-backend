package com.giantlink.grh.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.giantlink.grh.entities.CompanyEntity;
import com.giantlink.grh.services.CompanyEntityService;

@RestController
@RequestMapping("/api/v1/company/entity")
public class CompanyEntityController {

	@Autowired
	CompanyEntityService companyEntityService;
	
	@PostMapping
	public ResponseEntity<CompanyEntity> add(@RequestBody CompanyEntity companyEntity){
		return new ResponseEntity<CompanyEntity>(companyEntityService.add(companyEntity), HttpStatus.CREATED);
	}
}
