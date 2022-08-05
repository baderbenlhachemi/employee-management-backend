package com.giantlink.grh.services;

import java.util.List;

import com.giantlink.grh.dto.request.CompanyEntityRequest;
import com.giantlink.grh.dto.response.CompanyEntityResponse;
import com.giantlink.grh.exceptions.AlreadyExistsException;
import com.giantlink.grh.exceptions.NotFoundException;

public interface CompanyEntityService {
	CompanyEntityResponse add(CompanyEntityRequest companyEntityRequest) throws AlreadyExistsException;

	CompanyEntityResponse update(Integer id, CompanyEntityRequest companyEntityRequest) throws AlreadyExistsException, NotFoundException;

	CompanyEntityResponse get(Integer id) throws NotFoundException;

	List<CompanyEntityResponse> get() throws NotFoundException;

	void delete(Integer id) throws NotFoundException;

	CompanyEntityResponse getByName(String name) throws NotFoundException;
}
