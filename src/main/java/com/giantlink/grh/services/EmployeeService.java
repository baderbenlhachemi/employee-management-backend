package com.giantlink.grh.services;

import com.giantlink.grh.dto.request.EmployeeRequest;
import com.giantlink.grh.dto.response.EmployeeResponse;
import com.giantlink.grh.exceptions.AlreadyExistsException;
import com.giantlink.grh.exceptions.NotFoundException;

import java.util.List;

public interface EmployeeService {

    EmployeeResponse add(EmployeeRequest employeeRequest) throws AlreadyExistsException;

    EmployeeResponse update(Integer id, EmployeeRequest employeeRequest) throws AlreadyExistsException, NotFoundException;

    EmployeeResponse get(Integer id) throws NotFoundException;

    List<EmployeeResponse> get() throws NotFoundException;

    void delete(Integer id) throws NotFoundException;

    EmployeeResponse getByName(String name) throws NotFoundException;
}
