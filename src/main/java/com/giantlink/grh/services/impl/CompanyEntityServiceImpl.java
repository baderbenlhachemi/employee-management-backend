package com.giantlink.grh.services.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.giantlink.grh.entities.CompanyEntity;
import com.giantlink.grh.repositories.CompanyEntityRepository;
import com.giantlink.grh.services.CompanyEntityService;

@Service
public class CompanyEntityServiceImpl implements CompanyEntityService {
	@Autowired
	CompanyEntityRepository companyEntityRepository;

	@Override
	public CompanyEntity add(CompanyEntity companyEntity) {
		return companyEntityRepository.save(companyEntity);
	}

	@Override
	public CompanyEntity get(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<CompanyEntity> get() {
		// TODO Auto-generated method stub
		return null;
	}

}
