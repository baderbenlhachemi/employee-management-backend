package com.giantlink.grh.services;

import com.giantlink.grh.dto.request.ProjectRequest;
import com.giantlink.grh.dto.response.ProjectResponse;
import com.giantlink.grh.exceptions.AlreadyExistsException;
import com.giantlink.grh.exceptions.NotFoundException;

import java.util.List;

public interface ProjectService {

    ProjectResponse add(ProjectRequest projectRequest) throws AlreadyExistsException;

    ProjectResponse update(Integer id, ProjectRequest projectRequest) throws AlreadyExistsException, NotFoundException;

    ProjectResponse get(Integer id) throws NotFoundException;

    List<ProjectResponse> get() throws NotFoundException;

    void delete(Integer id) throws NotFoundException;

    ProjectResponse getByName(String name) throws NotFoundException;

}
