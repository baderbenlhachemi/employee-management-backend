package com.giantlink.grh.controllers;

import com.giantlink.grh.dto.request.ProjectRequest;
import com.giantlink.grh.dto.response.ProjectResponse;
import com.giantlink.grh.exceptions.AlreadyExistsException;
import com.giantlink.grh.exceptions.NotFoundException;
import com.giantlink.grh.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/company/project")
public class ProjectController {

    private final ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("")
    public List<ProjectResponse> get() throws NotFoundException {
        return projectService.get();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ProjectResponse> get(@PathVariable Integer id) throws NotFoundException {
        return new ResponseEntity<ProjectResponse>(projectService.get(id), HttpStatus.OK);
    }

    @GetMapping("/getname/{name}")
    public ResponseEntity<ProjectResponse> getByName(@PathVariable String name) throws NotFoundException {
        return new ResponseEntity<ProjectResponse>(projectService.getByName(name), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<ProjectResponse> add(@RequestBody @Valid ProjectRequest projectRequest) throws AlreadyExistsException {
        return new ResponseEntity<ProjectResponse>(projectService.add(projectRequest), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ProjectResponse> update(@PathVariable Integer id, @RequestBody @Valid ProjectRequest projectRequest) throws AlreadyExistsException, NotFoundException {
        return new ResponseEntity<ProjectResponse>(projectService.update(id, projectRequest), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id) throws NotFoundException {
        projectService.delete(id);
    }

}
