package com.giantlink.grh.services;

import java.util.List;

import com.giantlink.grh.dto.request.CompanyRequest;
import com.giantlink.grh.dto.response.CompanyResponse;
import com.giantlink.grh.entities.Company;

public interface CompanyService {

	CompanyResponse add(CompanyRequest companyRequest);

	CompanyResponse update(Integer id, CompanyRequest companyRequest);

	CompanyResponse get(Integer id);

	CompanyResponse getByName(String name);

	List<CompanyResponse> get();

	void delete(Integer id);
}
