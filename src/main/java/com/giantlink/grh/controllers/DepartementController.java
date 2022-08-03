package com.giantlink.grh.controllers;

import com.giantlink.grh.dto.request.DepartementRequest;
import com.giantlink.grh.dto.response.DepartementResponse;
import com.giantlink.grh.entities.Departement;
import com.giantlink.grh.services.DepartementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public List<DepartementResponse> get() {
        return departementService.get();
    }

    @GetMapping("/get/{id}")
    public DepartementResponse get(@PathVariable Integer id) {
        return departementService.get(id);
    }

    @PostMapping("/add")
    public DepartementResponse add(@RequestBody DepartementRequest departementRequest) {
        return departementService.add(departementRequest);
    }

    @PutMapping("/update/{id}")
    public DepartementResponse update(@PathVariable Integer id, @RequestBody DepartementRequest departementRequest) {
        return departementService.update(id, departementRequest);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id) {
        departementService.delete(id);
    }


}
