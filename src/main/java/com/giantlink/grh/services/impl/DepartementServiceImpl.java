package com.giantlink.grh.services.impl;

import java.util.List;
import java.util.Optional;

import com.giantlink.grh.dto.mapper.DepartementMapper;
import com.giantlink.grh.dto.request.DepartementRequest;
import com.giantlink.grh.dto.response.DepartementResponse;
import com.giantlink.grh.entities.Departement;
import com.giantlink.grh.exceptions.AlreadyExistsException;
import com.giantlink.grh.exceptions.NotFoundException;
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
	public DepartementResponse add(DepartementRequest departementRequest) throws AlreadyExistsException {
		Departement departement = DepartementMapper.MAPPER.fromRequestToEntity(departementRequest);
		if (departementRepository.findByName(departement.getName()).isPresent()) {
			throw new AlreadyExistsException("Departement with name " + departement.getName() + " already exists");
		}
		departementRepository.save(departement);
		return DepartementMapper.MAPPER.fromEntityToResponse(departement);
	}

	@Override
	public DepartementResponse update(Integer id, DepartementRequest departementRequest) throws AlreadyExistsException, NotFoundException {
		Departement departement = departementRepository.findById(id).orElseThrow(() -> new NotFoundException("Departement not found"));
		Departement newDepartement = DepartementMapper.MAPPER.fromRequestToEntity(departementRequest);
		departement.setName(newDepartement.getName());
		departementRepository.save(departement);
		return DepartementMapper.MAPPER.fromEntityToResponse(departement);
	}

	@Override
	public DepartementResponse get(Integer id) throws NotFoundException {
		Optional<Departement> departement = departementRepository.findById(id);
		if (departement.isPresent()) {
			return DepartementMapper.MAPPER.fromEntityToResponse(departement.get());
		} else {
			throw new NotFoundException("Departement not found");
		}
	}

	@Override
	public DepartementResponse getByName(String name) throws NotFoundException {
		Optional<Departement> departement = departementRepository.findByName(name);
		if (departement.isPresent()) {
			return DepartementMapper.MAPPER.fromEntityToResponse(departement.get());
		} else {
			throw new NotFoundException("Departement not found");
		}
	}


	@Override
	public List<DepartementResponse> get() throws NotFoundException {
			if (departementRepository.findAll().isEmpty()) {
				throw new NotFoundException("Company Entities not found");
			} else {
				return DepartementMapper.MAPPER.fromEntityListToResponse(departementRepository.findAll());
			}
		}

	@Override
	public void delete(Integer id) throws NotFoundException {
		if (departementRepository.findById(id).isPresent()) {
			departementRepository.deleteById(id);
		} else {
			throw new NotFoundException("Departement not found");
		}
	}

}
