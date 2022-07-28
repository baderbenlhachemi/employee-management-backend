package com.giantlink.grh.services;

import java.util.Set;

import com.giantlink.grh.entities.Departement;

public interface DepartementService {
	Departement add(Departement departement);

	Departement get(Integer id);

	Departement get(String name);

	Set<Departement> get();
	
	void delete(Integer id);
}
