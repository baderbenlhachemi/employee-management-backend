package com.giantlink.grh.services;

import com.giantlink.grh.dto.request.EmployeeRequest;
import com.giantlink.grh.dto.response.EmployeeResponse;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    EmployeeResponse add(EmployeeRequest employeeRequest);

    EmployeeResponse update(Integer id, EmployeeRequest employeeRequest);

    EmployeeResponse get(Integer id);

    List<EmployeeResponse> get();

    void delete(Integer id);

    EmployeeResponse getByName(String name);
}
