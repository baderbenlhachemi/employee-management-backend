package com.giantlink.grh.services.impl;

import java.util.List;

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
	public CompanyEntity add(CompanyEntity companyEntity) {
		return companyEntityRepository.save(companyEntity);
	}

	@Override
	public CompanyEntity update(Integer id, CompanyEntity companyEntity) {
		return companyEntityRepository.save(companyEntity);
	}

	@Override
	public CompanyEntity get(Integer id) {
		// TODO Auto-generated method stub
		return companyEntityRepository.findById(id).get();
	}

	@Override
	public List<CompanyEntity> get() {
		// TODO Auto-generated method stub
		return companyEntityRepository.findAll();
	}

	@Override
	public void delete(Integer id) { companyEntityRepository.deleteById(id); }

}
