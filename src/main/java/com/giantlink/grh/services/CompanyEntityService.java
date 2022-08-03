package com.giantlink.grh.services;

import java.util.List;

import com.giantlink.grh.dto.request.CompanyEntityRequest;
import com.giantlink.grh.dto.response.CompanyEntityResponse;
import com.giantlink.grh.entities.CompanyEntity;

public interface CompanyEntityService {
	CompanyEntityResponse add(CompanyEntityRequest companyEntityRequest);

	CompanyEntityResponse update(Integer id, CompanyEntityRequest companyEntityRequest);

	CompanyEntityResponse get(Integer id);

	List<CompanyEntityResponse> get();

	void delete(Integer id);
}
