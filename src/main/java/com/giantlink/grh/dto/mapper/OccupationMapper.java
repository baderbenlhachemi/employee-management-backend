package com.giantlink.grh.dto.mapper;

import com.giantlink.grh.dto.request.OccupationRequest;
import com.giantlink.grh.dto.response.OccupationResponse;
import com.giantlink.grh.entities.Occupation;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OccupationMapper {
    OccupationMapper MAPPER = Mappers.getMapper(OccupationMapper.class);
    Occupation fromRequestToEntity(OccupationRequest occupationRequest);
    OccupationResponse fromEntityToResponse(Occupation occupation);
    List<OccupationResponse> fromEntityListToResponse(List<Occupation> occupations);
}
