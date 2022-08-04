package com.giantlink.grh.controllers;

import com.giantlink.grh.dto.request.ProjectRequest;
import com.giantlink.grh.dto.response.ProjectResponse;
import com.giantlink.grh.entities.Project;
import com.giantlink.grh.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public List<ProjectResponse> get() {
        return projectService.get();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ProjectResponse> get(@PathVariable Integer id) {
        return new ResponseEntity<ProjectResponse>(projectService.get(id), HttpStatus.OK);
    }

    @GetMapping("/getname/{name}")
    public ResponseEntity<ProjectResponse> getByName(@PathVariable String name) {
        return new ResponseEntity<ProjectResponse>(projectService.getByName(name), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<ProjectResponse> add(@RequestBody ProjectRequest projectRequest) {
        return new ResponseEntity<ProjectResponse>(projectService.add(projectRequest), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ProjectResponse> update(@PathVariable Integer id, @RequestBody ProjectRequest projectRequest) {
        return new ResponseEntity<ProjectResponse>(projectService.update(id, projectRequest), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id) {
        projectService.delete(id);
    }

}
