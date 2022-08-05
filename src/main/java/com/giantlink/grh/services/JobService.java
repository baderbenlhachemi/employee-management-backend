package com.giantlink.grh.services;

import com.giantlink.grh.dto.request.JobRequest;
import com.giantlink.grh.dto.response.JobResponse;
import com.giantlink.grh.exceptions.AlreadyExistsException;
import com.giantlink.grh.exceptions.NotFoundException;

import java.util.List;

public interface JobService {

    JobResponse add(JobRequest jobRequest) throws AlreadyExistsException;

    JobResponse update(Integer id, JobRequest jobrequest) throws AlreadyExistsException, NotFoundException;

    JobResponse get(Integer id) throws NotFoundException;

    JobResponse getByName(String name) throws NotFoundException;

    List<JobResponse> get() throws NotFoundException;

    void delete(Integer id) throws NotFoundException;
}
