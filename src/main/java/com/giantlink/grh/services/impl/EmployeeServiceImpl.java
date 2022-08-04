package com.giantlink.grh.services.impl;

import com.giantlink.grh.dto.mapper.EmployeeMapper;
import com.giantlink.grh.dto.request.EmployeeRequest;
import com.giantlink.grh.dto.response.EmployeeResponse;
import com.giantlink.grh.entities.Employee;
import com.giantlink.grh.repositories.EmployeeRepository;
import com.giantlink.grh.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;


    @Override
    public EmployeeResponse add(EmployeeRequest employeeRequest) {
        Employee employee = EmployeeMapper.MAPPER.fromRequestToEntity(employeeRequest);
        employeeRepository.save(employee);
        return EmployeeMapper.MAPPER.fromEntityToResponse(employee);
    }

    @Override
    public EmployeeResponse update(Integer id, EmployeeRequest employeeRequest) {
        Employee employee = EmployeeMapper.MAPPER.fromRequestToEntity(employeeRequest);
        employee.setId(id);
        employeeRepository.save(employee);
        return EmployeeMapper.MAPPER.fromEntityToResponse(employee);
    }

    @Override
    public EmployeeResponse get(Integer id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        return EmployeeMapper.MAPPER.fromEntityToResponse(employee.get());
    }

    @Override
    public List<EmployeeResponse> get() {
        List<Employee> employee = employeeRepository.findAll();
        return EmployeeMapper.MAPPER.fromEntityListToResponse(employee);
    }

    @Override
    public void delete(Integer id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public EmployeeResponse getByName(String name) {
        return EmployeeMapper.MAPPER.fromEntityToResponse(employeeRepository.findByName(name));
    }
}
