package com.giantlink.grh.dto.mapper;

import com.giantlink.grh.dto.request.CompanyEntityRequest;
import com.giantlink.grh.dto.response.CompanyEntityResponse;
import com.giantlink.grh.entities.CompanyEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
@Mapper
public interface CompanyEntityMapper {
    CompanyEntityMapper MAPPER = Mappers.getMapper(CompanyEntityMapper.class);
    CompanyEntity fromRequestToEntity(CompanyEntityRequest companyEntityRequest);
    CompanyEntityResponse fromEntityToResponse(CompanyEntity companyEntity);
    List<CompanyEntityResponse> fromEntityListToResponse(List<CompanyEntity> companyEntities);
}
