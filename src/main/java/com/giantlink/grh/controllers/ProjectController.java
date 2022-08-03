package com.giantlink.grh.controllers;

import com.giantlink.grh.entities.Project;
import com.giantlink.grh.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Project> get() {
        return projectService.get();
    }

    @GetMapping("/get/{id}")
    public Project get(@PathVariable Integer id) {
        return projectService.get(id);
    }

    @GetMapping("/getname/{name}")
    public Project get(@PathVariable String name) {
        return projectService.get(name);
    }

    @PostMapping("/add")
    public Project add(@RequestBody Project project) {
        return projectService.add(project);
    }

    @PutMapping("/update/{id}")
    public Project update(@PathVariable Integer id, @RequestBody Project project) {
        project.setId(id);
        return projectService.update(id, project);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id) {
        projectService.delete(id);
    }

}
