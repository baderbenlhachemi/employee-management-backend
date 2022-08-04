package com.giantlink.grh.services.impl;

import java.util.List;
import java.util.Optional;

import com.giantlink.grh.dto.mapper.CompanyMapper;
import com.giantlink.grh.dto.request.CompanyRequest;
import com.giantlink.grh.dto.response.CompanyResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.giantlink.grh.entities.Company;
import com.giantlink.grh.repositories.CompanyRepository;
import com.giantlink.grh.services.CompanyService;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Service
public class CompanyServiceImpl implements CompanyService {
	private final CompanyRepository companyRepository;

	@Autowired
	public CompanyServiceImpl(CompanyRepository companyRepository) {
		this.companyRepository = companyRepository;
	}

	@Override
	public CompanyResponse add(CompanyRequest companyRequest) {
		Company company = CompanyMapper.MAPPER.fromRequestToEntity(companyRequest);
		companyRepository.save(company);
		return CompanyMapper.MAPPER.fromEntityToResponse(company);
	}

	@Override
	public CompanyResponse update(Integer id, CompanyRequest companyRequest) {

		Optional<Company> checkExistingCompany = companyRepository.findById(id);
		if (checkExistingCompany.isPresent()) {
			Company company = CompanyMapper.MAPPER.fromRequestToEntity(companyRequest);
			company.setId(id);
			companyRepository.save(company);
			return CompanyMapper.MAPPER.fromEntityToResponse(company);
		} else {
			throw new RuntimeException("Company not found");
		}
	}

	@Override
	public CompanyResponse get(Integer id) {
		Optional<Company> company = companyRepository.findById(id);
		return CompanyMapper.MAPPER.fromEntityToResponse(company.get());
	}

	@Override
	public CompanyResponse getByName(String name) {
		return CompanyMapper.MAPPER.fromEntityToResponse(companyRepository.findByName(name));
	}

	@Override
	public List<CompanyResponse> get() {
		List<Company> company = companyRepository.findAll();
		return CompanyMapper.MAPPER.fromEntityListToResponse(company);
	}

	@Override
	public void delete(Integer id) {
		companyRepository.deleteById(id);
	}

}
