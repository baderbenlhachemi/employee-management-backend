package com.giantlink.grh.services;

import com.giantlink.grh.dto.request.OccupationRequest;
import com.giantlink.grh.dto.response.OccupationResponse;
import com.giantlink.grh.entities.Occupation;

import java.util.List;

public interface OccupationService {

    OccupationResponse add(OccupationRequest occupationRequest);

    OccupationResponse update(Integer id, OccupationRequest occupationRequest);

    OccupationResponse get(Integer id);

    List<OccupationResponse> get();

    void delete(Integer id);

    OccupationResponse getByName(String name);
}
