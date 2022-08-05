package com.giantlink.grh.services;

import com.giantlink.grh.dto.request.OccupationRequest;
import com.giantlink.grh.dto.response.OccupationResponse;
import com.giantlink.grh.exceptions.AlreadyExistsException;
import com.giantlink.grh.exceptions.NotFoundException;

import java.util.List;

public interface OccupationService {

    OccupationResponse add(OccupationRequest occupationRequest) throws AlreadyExistsException;

    OccupationResponse update(Integer id, OccupationRequest occupationRequest) throws AlreadyExistsException, NotFoundException;

    OccupationResponse get(Integer id) throws NotFoundException;

    List<OccupationResponse> get() throws NotFoundException;

    void delete(Integer id) throws NotFoundException;

    OccupationResponse getByName(String name) throws NotFoundException;
}
