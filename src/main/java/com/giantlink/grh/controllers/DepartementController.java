package com.giantlink.grh.controllers;

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
    public List<Departement> get() {
        return departementService.get();
    }

    @GetMapping("/get/{id}")
    public Departement get(@PathVariable Integer id) {
        return departementService.get(id);
    }

    @PostMapping("/add")
    public Departement add(@RequestBody Departement departement) {
        return departementService.add(departement);
    }

    @PutMapping("/update/{id}")
    public Departement update(@PathVariable Integer id, @RequestBody Departement departement) {
        departement.setId(id);
        return departementService.update(id, departement);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id) {
        departementService.delete(id);
    }


}
