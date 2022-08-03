package com.giantlink.grh.controllers;

import com.giantlink.grh.entities.Employee;
import com.giantlink.grh.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/company/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping("")
    public List<Employee> get() {
        return employeeService.get();
    }

    @GetMapping("/get/{id}")
    public Employee get(@PathVariable Integer id) {
        return employeeService.get(id);
    }

    @GetMapping("/getname/{name}")
    public Employee get(@PathVariable String name) {
        return employeeService.get(name);
    }

    @PostMapping("/add")
    public Employee add(@RequestBody Employee employee) {
        return employeeService.add(employee);
    }

    @PutMapping("/update/{id}")
    public Employee update(@PathVariable Integer id, @RequestBody Employee employee) {
        employee.setId(id);
        return employeeService.update(id, employee);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id) {
        employeeService.delete(id);
    }


}
