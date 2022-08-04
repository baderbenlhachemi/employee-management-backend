package com.giantlink.grh.dto.mapper;

import com.giantlink.grh.dto.request.JobRequest;
import com.giantlink.grh.dto.response.JobResponse;
import com.giantlink.grh.entities.Job;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface JobMapper {
    JobMapper MAPPER = Mappers.getMapper(JobMapper.class);
    Job fromRequestToEntity(JobRequest jobRequest);
    JobResponse fromEntityToResponse(Job job);
    List<JobResponse> fromEntityListToResponse(List<Job> jobs);

}
