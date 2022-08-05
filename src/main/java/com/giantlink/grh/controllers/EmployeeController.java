package com.giantlink.grh.controllers;

import com.giantlink.grh.dto.request.EmployeeRequest;
import com.giantlink.grh.dto.response.EmployeeResponse;
import com.giantlink.grh.exceptions.AlreadyExistsException;
import com.giantlink.grh.exceptions.NotFoundException;
import com.giantlink.grh.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/company/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping("")
    public ResponseEntity<List<EmployeeResponse>> get() throws NotFoundException {
        return new ResponseEntity<List<EmployeeResponse>>((List<EmployeeResponse>) employeeService.get(), HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<EmployeeResponse> get(@PathVariable Integer id) throws NotFoundException {
        return new ResponseEntity<EmployeeResponse>(employeeService.get(id), HttpStatus.OK);
    }

    @GetMapping("/getname/{name}")
    public ResponseEntity<EmployeeResponse> getByName(@PathVariable String name) throws NotFoundException {
        return new ResponseEntity<EmployeeResponse>(employeeService.getByName(name), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<EmployeeResponse> add(@RequestBody @Valid EmployeeRequest employeeRequest) throws AlreadyExistsException {
        return new ResponseEntity<EmployeeResponse>(employeeService.add(employeeRequest), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<EmployeeResponse> update(@PathVariable Integer id, @RequestBody @Valid EmployeeRequest employeeRequest) throws AlreadyExistsException, NotFoundException {
        return new ResponseEntity<EmployeeResponse>(employeeService.update(id, employeeRequest), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id) throws NotFoundException {
        employeeService.delete(id);
    }


}
