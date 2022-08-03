package com.giantlink.grh.services.impl;

import java.util.List;
import java.util.Optional;

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
	public Departement add(Departement departement) {
		// TODO Auto-generated method stub
		return departementRepository.save(departement);
	}

	@Override
	public Departement update(Integer id, Departement departement) {
		return departementRepository.save(departement);
	}

	@Override
	public Departement get(Integer id) {
		// TODO Auto-generated method stub
		return departementRepository.findById(id).get();
	}

	@Override
	public Optional<Departement> get(String name) {
		// TODO Auto-generated method stub
		return departementRepository.findByName(name);
	}

	@Override
	public List<Departement> get() {
		// TODO Auto-generated method stub
		return departementRepository.findAll();
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub

	}

}
