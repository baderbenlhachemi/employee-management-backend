package com.giantlink.grh.services.impl;

import com.giantlink.grh.dto.mapper.JobMapper;
import com.giantlink.grh.dto.request.JobRequest;
import com.giantlink.grh.dto.response.JobResponse;
import com.giantlink.grh.entities.Job;
import com.giantlink.grh.repositories.JobRepository;
import com.giantlink.grh.services.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImpl implements JobService {

    private final JobRepository jobRepository;

    @Autowired
    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public JobResponse add(JobRequest jobRequest) {
        Job job = JobMapper.MAPPER.fromRequestToEntity(jobRequest);
        jobRepository.save(job);
        return JobMapper.MAPPER.fromEntityToResponse(job);
    }

    @Override
    public JobResponse update(Integer id, JobRequest jobRequest) {
        Job job = JobMapper.MAPPER.fromRequestToEntity(jobRequest);
        job.setId(id);
        jobRepository.save(job);
        return JobMapper.MAPPER.fromEntityToResponse(job);
    }

    @Override
    public JobResponse get(Integer id) {
        Optional<Job> job = jobRepository.findById(id);
        return JobMapper.MAPPER.fromEntityToResponse(job.get());
    }

    @Override
    public JobResponse get(String name) {
        return JobMapper.MAPPER.fromEntityToResponse(jobRepository.findByName(name));
    }

    @Override
    public List<JobResponse> get() {
        List<Job> job = jobRepository.findAll();
        return JobMapper.MAPPER.fromEntityListToResponse(job);
    }

    @Override
    public void delete(Integer id) {
        jobRepository.deleteById(id);
    }
}

