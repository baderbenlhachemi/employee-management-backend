package com.giantlink.grh.controllers;

import com.giantlink.grh.entities.Occupation;
import com.giantlink.grh.services.OccupationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/company/occupation")
public class OccupationController {

private final OccupationService occupationService;

    public OccupationController(OccupationService occupationService) {
        this.occupationService = occupationService;
    }

    @GetMapping("")
    public List<Occupation> get() {
        return occupationService.get();
    }

    @GetMapping("/get/{id}")
    public Occupation get(@PathVariable Integer id) {
        return occupationService.get(id);
    }

    @GetMapping("/getname/{name}")
    public Occupation get(@PathVariable String name) {
        return occupationService.get(name);
    }

    @PostMapping("/add")
    public Occupation add(@RequestBody Occupation occupation) {
        return occupationService.add(occupation);
    }

    @PutMapping("/update/{id}")
    public Occupation update(@PathVariable Integer id, @RequestBody Occupation occupation) {
        occupation.setId(id);
        return occupationService.add(occupation);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id) {
        occupationService.delete(id);
    }

}


