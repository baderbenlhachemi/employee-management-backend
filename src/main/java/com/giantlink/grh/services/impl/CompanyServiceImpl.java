package com.giantlink.grh.services.impl;

import java.util.List;
import java.util.Optional;

import com.giantlink.grh.dto.mapper.CompanyMapper;
import com.giantlink.grh.dto.request.CompanyRequest;
import com.giantlink.grh.dto.response.CompanyResponse;
import com.giantlink.grh.exceptions.AlreadyExistsException;
import com.giantlink.grh.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.giantlink.grh.entities.Company;
import com.giantlink.grh.repositories.CompanyRepository;
import com.giantlink.grh.services.CompanyService;


@Service
public class CompanyServiceImpl implements CompanyService {
	private final CompanyRepository companyRepository;

	@Autowired
	public CompanyServiceImpl(CompanyRepository companyRepository) {
		this.companyRepository = companyRepository;
	}

	@Override
	public CompanyResponse add(CompanyRequest companyRequest) throws AlreadyExistsException {
		Company company = CompanyMapper.MAPPER.fromRequestToEntity(companyRequest);
		if(companyRepository.findByName(company.getName())!=null) {
			throw new AlreadyExistsException("Company with name " + company.getName() + " already exists");
		}
		companyRepository.save(company);
		return CompanyMapper.MAPPER.fromEntityToResponse(company);
	}

	@Override
	public CompanyResponse update(Integer id, CompanyRequest companyRequest) throws AlreadyExistsException, NotFoundException {
		Company company = companyRepository.findById(id).orElseThrow(() -> new NotFoundException("Company not found"));

		Company newCompany = CompanyMapper.MAPPER.fromRequestToEntity(companyRequest);
		company.setName(newCompany.getName());
		company.setEmail(newCompany.getEmail());
		company.setAddress(newCompany.getAddress());
		company.setPhone(newCompany.getPhone());
		company.setWebsite(newCompany.getWebsite());
		company.setDescription(newCompany.getDescription());
		companyRepository.save(company);
		return CompanyMapper.MAPPER.fromEntityToResponse(company);
	}

	@Override
	public CompanyResponse get(Integer id) throws NotFoundException {
		Optional<Company> company = companyRepository.findById(id);
		if (company.isPresent()) {
			return CompanyMapper.MAPPER.fromEntityToResponse(company.get());
		} else {
			throw new NotFoundException("Company not found");
		}
	}

	@Override
	public CompanyResponse getByName(String name) throws NotFoundException {
		if (companyRepository.findByName(name) == null) {
			throw new NotFoundException("Company not found");
		}
		return CompanyMapper.MAPPER.fromEntityToResponse(companyRepository.findByName(name));
	}

	@Override
	public List<CompanyResponse> get() throws NotFoundException {
		if (companyRepository.findAll().isEmpty()) {
			throw new NotFoundException("Company not found");
		}
		List<Company> company = companyRepository.findAll();
		return CompanyMapper.MAPPER.fromEntityListToResponse(company);
	}

	@Override
	public Page<Company> get(Pageable pageable) {
		return companyRepository.findAll(pageable);
	}

	@Override
	public void delete(Integer id) throws NotFoundException {
		if (companyRepository.findById(id).isPresent()) {
			companyRepository.deleteById(id);
		} else {
			throw new NotFoundException("Company not found");
		}
	}

}
