package com.giantlink.grh.services.impl;

import java.util.List;
import java.util.Optional;

import com.giantlink.grh.dto.mapper.DepartementMapper;
import com.giantlink.grh.dto.request.DepartementRequest;
import com.giantlink.grh.dto.response.DepartementResponse;
import com.giantlink.grh.entities.Departement;
import com.giantlink.grh.repositories.DepartementRepository;
import com.giantlink.grh.services.DepartementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartementServiceImpl implements DepartementService {

	private final DepartementRepository departementRepository;

	@Autowired
	public DepartementServiceImpl(DepartementRepository departementRepository) {
		this.departementRepository = departementRepository;
	}

	@Override
	public DepartementResponse add(DepartementRequest departementRequest) {
		Departement departement = DepartementMapper.MAPPER.fromRequestToEntity(departementRequest);
		departementRepository.save(departement);
		return DepartementMapper.MAPPER.fromEntityToResponse(departement);
	}

	@Override
	public DepartementResponse update(Integer id, DepartementRequest departementRequest) {
		Departement departement = DepartementMapper.MAPPER.fromRequestToEntity(departementRequest);
		departement.setId(id);
		departementRepository.save(departement);
		return DepartementMapper.MAPPER.fromEntityToResponse(departement);
	}

	@Override
	public DepartementResponse get(Integer id) {
		Optional<Departement> departement = departementRepository.findById(id);
		return DepartementMapper.MAPPER.fromEntityToResponse(departement.get());
	}

	@Override
	public Optional<DepartementResponse> get(String name) {
		Optional<Departement> departement = departementRepository.findByName(name);
		return Optional.ofNullable(DepartementMapper.MAPPER.fromEntityToResponse(departement.get()));
	}

	@Override
	public List<DepartementResponse> get() {
		List<Departement> departement = departementRepository.findAll();
		return DepartementMapper.MAPPER.fromEntityListToResponse(departement);
	}

	@Override
	public void delete(Integer id) {
		departementRepository.deleteById(id);
	}

}
