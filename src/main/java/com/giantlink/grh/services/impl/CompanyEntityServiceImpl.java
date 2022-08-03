package com.giantlink.grh.services.impl;

import java.util.List;
import java.util.Optional;

import com.giantlink.grh.dto.mapper.CompanyEntityMapper;
import com.giantlink.grh.dto.request.CompanyEntityRequest;
import com.giantlink.grh.dto.response.CompanyEntityResponse;
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
		public CompanyEntityResponse add(CompanyEntityRequest companyEntityRequest) {
		CompanyEntity companyEntity = CompanyEntityMapper.MAPPER.fromRequestToEntity(companyEntityRequest);
		companyEntityRepository.save(companyEntity);
		return CompanyEntityMapper.MAPPER.fromEntityToResponse(companyEntity);
		}

		@Override
		public CompanyEntityResponse update(Integer id, CompanyEntityRequest companyEntityRequest) {
		CompanyEntity companyEntity = CompanyEntityMapper.MAPPER.fromRequestToEntity(companyEntityRequest);
		companyEntity.setId(id);
		companyEntityRepository.save(companyEntity);
		return CompanyEntityMapper.MAPPER.fromEntityToResponse(companyEntity);
		}

		@Override
		public CompanyEntityResponse get(Integer id) {
		Optional<CompanyEntity> companyEntity = companyEntityRepository.findById(id);
		return CompanyEntityMapper.MAPPER.fromEntityToResponse(companyEntity.get());
		}

		@Override
		public List<CompanyEntityResponse> get() {
		List<CompanyEntity> companyEntity = companyEntityRepository.findAll();
		return CompanyEntityMapper.MAPPER.fromEntityListToResponse(companyEntity);
	}

		@Override
		public void delete (Integer id){
			companyEntityRepository.deleteById(id);
		}

}
