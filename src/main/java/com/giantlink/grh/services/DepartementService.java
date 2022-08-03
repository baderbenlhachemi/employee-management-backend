package com.giantlink.grh.services;

import java.util.List;
import java.util.Optional;

import com.giantlink.grh.entities.Departement;

public interface DepartementService {
	Departement add(Departement departement);

	Departement update(Integer id, Departement departement);

	Departement get(Integer id);

	Optional<Departement> get(String name);

	List<Departement> get();
	
	void delete(Integer id);
}
