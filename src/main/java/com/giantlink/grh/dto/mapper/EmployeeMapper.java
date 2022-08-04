package com.giantlink.grh.dto.mapper;

import com.giantlink.grh.dto.request.EmployeeRequest;
import com.giantlink.grh.dto.response.EmployeeResponse;
import com.giantlink.grh.entities.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    EmployeeMapper MAPPER = Mappers.getMapper(EmployeeMapper.class);
    Employee fromRequestToEntity(EmployeeRequest employeeRequest);
    EmployeeResponse fromEntityToResponse(Employee employee);
    List<EmployeeResponse> fromEntityListToResponse(List<Employee> employees);
}
