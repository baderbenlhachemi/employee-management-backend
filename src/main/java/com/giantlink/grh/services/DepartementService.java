package com.giantlink.grh.services;

import java.util.List;

import com.giantlink.grh.dto.request.DepartementRequest;
import com.giantlink.grh.dto.response.DepartementResponse;
import com.giantlink.grh.exceptions.AlreadyExistsException;
import com.giantlink.grh.exceptions.NotFoundException;

public interface DepartementService {
	DepartementResponse add(DepartementRequest departementRequest) throws AlreadyExistsException;

	DepartementResponse update(Integer id, DepartementRequest departementRequest) throws AlreadyExistsException, NotFoundException;

	DepartementResponse get(Integer id) throws NotFoundException;

	DepartementResponse getByName(String name) throws NotFoundException;

	List<DepartementResponse> get() throws NotFoundException;

	void delete(Integer id) throws NotFoundException;
}
