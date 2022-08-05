package com.giantlink.grh.services.impl;

import com.giantlink.grh.dto.mapper.ProjectMapper;
import com.giantlink.grh.dto.request.ProjectRequest;
import com.giantlink.grh.dto.response.ProjectResponse;
import com.giantlink.grh.entities.Project;
import com.giantlink.grh.exceptions.AlreadyExistsException;
import com.giantlink.grh.exceptions.NotFoundException;
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
    public ProjectResponse add(ProjectRequest projectRequest) throws AlreadyExistsException {
        Project project = ProjectMapper.MAPPER.fromRequestToEntity(projectRequest);
        if(projectRepository.findByName(project.getName())!=null) {
            throw new AlreadyExistsException("Project with name " + project.getName() + " already exists");
        }
        projectRepository.save(project);
        return ProjectMapper.MAPPER.fromEntityToResponse(project);
    }

    @Override
    public ProjectResponse update(Integer id, ProjectRequest projectRequest) throws AlreadyExistsException, NotFoundException {
        Project project = ProjectMapper.MAPPER.fromRequestToEntity(projectRequest);
        if(projectRepository.findById(id).isPresent()){
            project.setId(id);
        }else {
            throw new NotFoundException("not found");
        }
        return ProjectMapper.MAPPER.fromEntityToResponse(projectRepository.save(project));
    }

    @Override
    public ProjectResponse get(Integer id) throws NotFoundException {
Optional<Project> project = projectRepository.findById(id);
        if (project.isPresent()) {
            return ProjectMapper.MAPPER.fromEntityToResponse(project.get());
        } else {
            throw new NotFoundException("Project not found");
        }
    }

    @Override
    public List<ProjectResponse> get() throws NotFoundException {
        List<Project> projects = projectRepository.findAll();
        if (projects.isEmpty()) {
            throw new NotFoundException("Project not found");
        }
        return ProjectMapper.MAPPER.fromEntityListToResponse(projects);
    }

    @Override
    public void delete(Integer id) throws NotFoundException {
        Optional<Project> project = projectRepository.findById(id);
        if (project.isPresent()) {
            projectRepository.delete(project.get());
        } else {
            throw new NotFoundException("Project not found");
        }
    }

    @Override
    public ProjectResponse getByName(String name) throws NotFoundException {
        if (projectRepository.findByName(name) == null) {
            throw new NotFoundException("Project not found");
        }
        return ProjectMapper.MAPPER.fromEntityToResponse(projectRepository.findByName(name));
    }
}
