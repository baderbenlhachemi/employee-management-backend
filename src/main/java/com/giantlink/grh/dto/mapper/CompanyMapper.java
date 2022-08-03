package com.giantlink.grh.dto.mapper;

import com.giantlink.grh.dto.request.CompanyRequest;
import com.giantlink.grh.dto.response.CompanyResponse;
import com.giantlink.grh.entities.Company;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CompanyMapper {
    CompanyMapper MAPPER = Mappers.getMapper(CompanyMapper.class);
    Company fromRequestToEntity(CompanyRequest companyRequest);
    CompanyResponse fromEntityToResponse(Company company);
    List<CompanyResponse> fromEntityListToResponse(List<Company> companies);
}
