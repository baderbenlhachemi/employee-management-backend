package com.giantlink.grh.services.impl;

import java.util.List;
import java.util.Optional;

import com.giantlink.grh.dto.mapper.CompanyEntityMapper;
import com.giantlink.grh.dto.request.CompanyEntityRequest;
import com.giantlink.grh.dto.response.CompanyEntityResponse;
import com.giantlink.grh.exceptions.AlreadyExistsException;
import com.giantlink.grh.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.giantlink.grh.entities.CompanyEntity;
import com.giantlink.grh.repositories.CompanyEntityRepository;
import com.giantlink.grh.services.CompanyEntityService;

@Service
public class CompanyEntityServiceImpl implements CompanyEntityService {
	private final CompanyEntityRepository companyEntityRepository;

		@Autowired
		public CompanyEntityServiceImpl(CompanyEntityRepository companyEntityRepository) {
		this.companyEntityRepository = companyEntityRepository;
		}

		@Override
		public CompanyEntityResponse add(CompanyEntityRequest companyEntityRequest) throws AlreadyExistsException {
		CompanyEntity companyEntity = CompanyEntityMapper.MAPPER.fromRequestToEntity(companyEntityRequest);
		if(companyEntityRepository.findByName(companyEntity.getName())!=null) {
			throw new AlreadyExistsException("Company Entity with name " + companyEntity.getName() + " already exists");
		}
		companyEntityRepository.save(companyEntity);
		return CompanyEntityMapper.MAPPER.fromEntityToResponse(companyEntity);
		}

		@Override
		public CompanyEntityResponse update(Integer id, CompanyEntityRequest companyEntityRequest) throws AlreadyExistsException, NotFoundException {
		CompanyEntity companyEntity = companyEntityRepository.findById(id).orElseThrow(() -> new NotFoundException("Company not found"));
		CompanyEntity newCompanyEntity = CompanyEntityMapper.MAPPER.fromRequestToEntity(companyEntityRequest);
		companyEntity.setName(newCompanyEntity.getName());
		companyEntityRepository.save(companyEntity);
		return CompanyEntityMapper.MAPPER.fromEntityToResponse(companyEntity);
		}

		@Override
		public CompanyEntityResponse get(Integer id) throws NotFoundException {
		Optional<CompanyEntity> companyEntity = companyEntityRepository.findById(id);
		if (companyEntity.isPresent()) {
			return CompanyEntityMapper.MAPPER.fromEntityToResponse(companyEntity.get());
		} else {
			throw new NotFoundException("Company Entity not found");
		}
		}


		@Override
		public List<CompanyEntityResponse> get() throws NotFoundException {
		if (companyEntityRepository.findAll().isEmpty()) {
			throw new NotFoundException("Company Entities not found");
		} else {
			return CompanyEntityMapper.MAPPER.fromEntityListToResponse(companyEntityRepository.findAll());
			}
		}

		@Override
		public void delete (Integer id) throws NotFoundException {
			if (companyEntityRepository.findById(id).isPresent()) {
				companyEntityRepository.deleteById(id);
			} else {
				throw new NotFoundException("Company Entity not found");
			}
		}

	@Override
	public CompanyEntityResponse getByName(String name) throws NotFoundException {
			if (companyEntityRepository.findByName(name) == null) {
				throw new NotFoundException("Company Entity not found");
			}
			return CompanyEntityMapper.MAPPER.fromEntityToResponse(companyEntityRepository.findByName(name));
		}


}
