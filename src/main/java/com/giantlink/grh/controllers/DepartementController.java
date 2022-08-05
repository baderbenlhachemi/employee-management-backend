package com.giantlink.grh.controllers;

import com.giantlink.grh.dto.request.DepartementRequest;
import com.giantlink.grh.dto.response.DepartementResponse;
import com.giantlink.grh.exceptions.AlreadyExistsException;
import com.giantlink.grh.exceptions.NotFoundException;
import com.giantlink.grh.services.DepartementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/company/departement")
public class DepartementController {

    private final DepartementService departementService;

    @Autowired
    public DepartementController(DepartementService departementService) {
        this.departementService = departementService;
    }

    @GetMapping("")
    public ResponseEntity<List<DepartementResponse>> get() throws NotFoundException {
        return new ResponseEntity<List<DepartementResponse>>(departementService.get(), HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<DepartementResponse> get(@PathVariable Integer id) throws NotFoundException {
        return new ResponseEntity<DepartementResponse>(departementService.get(id), HttpStatus.OK);
    }

    @GetMapping("/getname/{name}")
    public ResponseEntity<DepartementResponse> getByName(@PathVariable String name) throws NotFoundException {
        return new ResponseEntity<DepartementResponse>(departementService.getByName(name), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<DepartementResponse> add(@RequestBody @Valid DepartementRequest departementRequest) throws AlreadyExistsException {
        return new ResponseEntity<DepartementResponse>(departementService.add(departementRequest), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<DepartementResponse> update(@PathVariable Integer id, @RequestBody @Valid DepartementRequest departementRequest) throws NotFoundException, AlreadyExistsException {
        return new ResponseEntity<DepartementResponse>(departementService.update(id, departementRequest), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id) throws NotFoundException {
        departementService.delete(id);
    }


}
