package com.giantlink.grh.services;

import com.giantlink.grh.dto.request.ProjectRequest;
import com.giantlink.grh.dto.response.ProjectResponse;
import com.giantlink.grh.entities.Project;

import java.util.List;

public interface ProjectService {

    ProjectResponse add(ProjectRequest projectRequest);

    ProjectResponse update(Integer id, ProjectRequest projectRequest);

    ProjectResponse get(Integer id);

    List<ProjectResponse> get();

    void delete(Integer id);

    ProjectResponse getByName(String name);

}
