package com.giantlink.grh.dto.mapper;

import com.giantlink.grh.dto.request.ProjectRequest;
import com.giantlink.grh.dto.response.ProjectResponse;
import com.giantlink.grh.entities.Project;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProjectMapper {
    ProjectMapper MAPPER = Mappers.getMapper(ProjectMapper.class);
    ProjectResponse fromEntityToResponse(Project project);
    Project fromRequestToEntity(ProjectRequest projectRequest);
    List<ProjectResponse> fromEntityListToResponse(List<Project> projects);

}
