package com.giantlink.grh.dto.mapper;

import com.giantlink.grh.dto.request.DepartementRequest;
import com.giantlink.grh.dto.response.DepartementResponse;
import com.giantlink.grh.entities.Departement;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DepartementMapper {
    DepartementMapper MAPPER = Mappers.getMapper(DepartementMapper.class);
    Departement fromRequestToEntity(DepartementRequest departementRequest);
    DepartementResponse fromEntityToResponse(Departement departement);
    List<DepartementResponse> fromEntityListToResponse(List<Departement> departements);
}
