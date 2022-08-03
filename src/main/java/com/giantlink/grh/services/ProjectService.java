package com.giantlink.grh.services;

import com.giantlink.grh.entities.Project;

import java.util.List;

public interface ProjectService {

    Project add(Project project);

    Project update(Integer id, Project project);

    Project get(Integer id);

    Project get(String name);

    List<Project> get();

    void delete(Integer id);

}
