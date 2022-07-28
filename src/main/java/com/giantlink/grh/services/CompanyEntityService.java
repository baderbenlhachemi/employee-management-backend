package com.giantlink.grh.services;

import java.util.Set;

import com.giantlink.grh.entities.CompanyEntity;

public interface CompanyEntityService {
	CompanyEntity add(CompanyEntity companyEntity);

	CompanyEntity get(Integer id);

	Set<CompanyEntity> get();
}
