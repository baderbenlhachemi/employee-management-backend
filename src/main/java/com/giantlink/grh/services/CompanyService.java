package com.giantlink.grh.services;

import java.util.List;

import com.giantlink.grh.dto.request.CompanyRequest;
import com.giantlink.grh.dto.response.CompanyResponse;
import com.giantlink.grh.exceptions.AlreadyExistsException;
import com.giantlink.grh.exceptions.NotFoundException;

public interface CompanyService {

	CompanyResponse add(CompanyRequest companyRequest) throws AlreadyExistsException;

	CompanyResponse update(Integer id, CompanyRequest companyRequest) throws AlreadyExistsException, NotFoundException;

	CompanyResponse get(Integer id) throws NotFoundException;

	CompanyResponse getByName(String name) throws NotFoundException;

	List<CompanyResponse> get() throws NotFoundException;

	void delete(Integer id) throws NotFoundException;
}
