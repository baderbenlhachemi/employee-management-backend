package com.giantlink.grh.services;

import java.util.List;
import java.util.Optional;

import com.giantlink.grh.dto.request.DepartementRequest;
import com.giantlink.grh.dto.response.DepartementResponse;
import com.giantlink.grh.entities.Departement;

public interface DepartementService {
	DepartementResponse add(DepartementRequest departementRequest);

	DepartementResponse update(Integer id, DepartementRequest departementRequest);

	DepartementResponse get(Integer id);

	Optional<DepartementResponse> get(String name);

	List<DepartementResponse> get();
	
	void delete(Integer id);
}
