package com.giantlink.grh.services.impl;

import com.giantlink.grh.dto.mapper.ProjectMapper;
import com.giantlink.grh.dto.request.ProjectRequest;
import com.giantlink.grh.dto.response.ProjectResponse;
import com.giantlink.grh.entities.Project;
import com.giantlink.grh.repositories.ProjectRepository;
import com.giantlink.grh.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;

    @Autowired
    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }


    @Override
    public ProjectResponse add(ProjectRequest projectRequest) {
        Project project = ProjectMapper.MAPPER.fromRequestToEntity(projectRequest);
        projectRepository.save(project);
        return ProjectMapper.MAPPER.fromEntityToResponse(project);
    }

    @Override
    public ProjectResponse update(Integer id, ProjectRequest projectRequest) {
        Project project = ProjectMapper.MAPPER.fromRequestToEntity(projectRequest);
        project.setId(id);
        projectRepository.save(project);
        return ProjectMapper.MAPPER.fromEntityToResponse(project);
    }

    @Override
    public ProjectResponse get(Integer id) {
        Optional<Project> project = projectRepository.findById(id);
        return ProjectMapper.MAPPER.fromEntityToResponse(project.get());
    }

    @Override
    public List<ProjectResponse> get() {
        List<Project> project = projectRepository.findAll();
        return ProjectMapper.MAPPER.fromEntityListToResponse(project);
    }

    @Override
    public void delete(Integer id) {
        projectRepository.deleteById(id);
    }

    @Override
    public ProjectResponse getByName(String name) {
        return ProjectMapper.MAPPER.fromEntityToResponse(projectRepository.findByName(name));
    }
}
