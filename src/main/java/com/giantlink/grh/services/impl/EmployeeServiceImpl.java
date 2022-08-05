package com.giantlink.grh.services.impl;

import com.giantlink.grh.dto.mapper.EmployeeMapper;
import com.giantlink.grh.dto.request.EmployeeRequest;
import com.giantlink.grh.dto.response.EmployeeResponse;
import com.giantlink.grh.entities.Employee;
import com.giantlink.grh.exceptions.AlreadyExistsException;
import com.giantlink.grh.exceptions.NotFoundException;
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
    public EmployeeResponse add(EmployeeRequest employeeRequest) throws AlreadyExistsException {
        Employee employee = EmployeeMapper.MAPPER.fromRequestToEntity(employeeRequest);
        if(employeeRepository.findByName(employee.getName())!=null) {
            throw new AlreadyExistsException("Employee with name " + employee.getName() + " already exists");
        }
        employeeRepository.save(employee);
        return EmployeeMapper.MAPPER.fromEntityToResponse(employee);
    }

    @Override
    public EmployeeResponse update(Integer id, EmployeeRequest employeeRequest) throws AlreadyExistsException, NotFoundException {
        Employee employee = EmployeeMapper.MAPPER.fromRequestToEntity(employeeRequest);
        if(employeeRepository.findById(id).isPresent()){
            employee.setId(id);
        }else {
            throw new NotFoundException("not found");
        }
        return EmployeeMapper.MAPPER.fromEntityToResponse(employeeRepository.save(employee));
    }

    @Override
    public EmployeeResponse get(Integer id) throws NotFoundException {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isPresent()) {
            return EmployeeMapper.MAPPER.fromEntityToResponse(employee.get());
        } else {
            throw new NotFoundException("Employee not found");
        }
    }

    @Override
    public List<EmployeeResponse> get() throws NotFoundException {
        List<Employee> employees = employeeRepository.findAll();
        if (employees.isEmpty()) {
            throw new NotFoundException("Employee not found");
        }
        return EmployeeMapper.MAPPER.fromEntityListToResponse(employees);
    }

    @Override
    public void delete(Integer id) throws NotFoundException {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isPresent()) {
            employeeRepository.delete(employee.get());
        } else {
            throw new NotFoundException("Employee not found");
        }
    }

    @Override
    public EmployeeResponse getByName(String name) throws NotFoundException {
        if (employeeRepository.findByName(name) == null) {
            throw new NotFoundException("Employee not found");
        }
        return EmployeeMapper.MAPPER.fromEntityToResponse(employeeRepository.findByName(name));
    }
}
