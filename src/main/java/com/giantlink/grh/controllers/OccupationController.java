package com.giantlink.grh.controllers;

import com.giantlink.grh.dto.request.OccupationRequest;
import com.giantlink.grh.dto.response.OccupationResponse;
import com.giantlink.grh.entities.Occupation;
import com.giantlink.grh.services.OccupationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<OccupationResponse>> get() {
        return new ResponseEntity<List<OccupationResponse>>(occupationService.get(), HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<OccupationResponse> get(@PathVariable Integer id) {
        return new ResponseEntity<OccupationResponse>(occupationService.get(id), HttpStatus.OK);
    }

    @GetMapping("/getname/{name}")
    public ResponseEntity<OccupationResponse> getByName(@PathVariable String name) {
        return new ResponseEntity<OccupationResponse>(occupationService.getByName(name), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<OccupationResponse> add(@RequestBody OccupationRequest occupationRequest) {
        return new ResponseEntity<OccupationResponse>(occupationService.add(occupationRequest), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<OccupationResponse> update(@PathVariable Integer id, @RequestBody OccupationRequest occupationRequest) {
        return new ResponseEntity<OccupationResponse>(occupationService.update(id, occupationRequest), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id) {
        occupationService.delete(id);
    }

}


