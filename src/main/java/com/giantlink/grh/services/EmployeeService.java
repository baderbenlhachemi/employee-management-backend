package com.giantlink.grh.services;

import com.giantlink.grh.entities.Employee;

import java.util.List;

public interface EmployeeService {

    Employee add(Employee employee);

    Employee update(Integer id, Employee employee);

    Employee get(Integer id);

    Employee get(String name);

    List<Employee> get();

    void delete(Integer id);

}
