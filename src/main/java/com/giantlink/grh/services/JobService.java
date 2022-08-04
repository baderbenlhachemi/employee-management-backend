package com.giantlink.grh.services;

import com.giantlink.grh.dto.request.JobRequest;
import com.giantlink.grh.dto.response.JobResponse;
import com.giantlink.grh.entities.Job;

import java.util.List;

public interface JobService {

    JobResponse add(JobRequest jobRequest);

    JobResponse update(Integer id, JobRequest jobrequest);

    JobResponse get(Integer id);

    JobResponse get(String name);

    List<JobResponse> get();

    void delete(Integer id);

}
