package com.giantlink.grh.services.impl;

import com.giantlink.grh.entities.Employee;
import com.giantlink.grh.repositories.EmployeeRepository;
import com.giantlink.grh.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;


    @Override
    public Employee add(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee update(Integer id, Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee get(Integer id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public Employee get(String name) {
        return employeeRepository.findByName(name);
    }

    @Override
    public List<Employee> get() {
        return employeeRepository.findAll();
    }

    @Override
    public void delete(Integer id) {

    }
}
