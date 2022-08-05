package com.giantlink.grh.services.impl;

import com.giantlink.grh.dto.mapper.JobMapper;
import com.giantlink.grh.dto.request.JobRequest;
import com.giantlink.grh.dto.response.JobResponse;
import com.giantlink.grh.entities.Job;
import com.giantlink.grh.exceptions.AlreadyExistsException;
import com.giantlink.grh.exceptions.NotFoundException;
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
    public JobResponse add(JobRequest jobRequest) throws AlreadyExistsException {
        Job job = JobMapper.MAPPER.fromRequestToEntity(jobRequest);
        if (jobRepository.findByName(job.getName()) != null) {
            throw new AlreadyExistsException("Job with name " + job.getName() + " already exists");
        }
        jobRepository.save(job);
        return JobMapper.MAPPER.fromEntityToResponse(job);
    }

    @Override
    public JobResponse update(Integer id, JobRequest jobRequest) throws AlreadyExistsException, NotFoundException {
        Job job = JobMapper.MAPPER.fromRequestToEntity(jobRequest);
        if (jobRepository.findById(id).isPresent()) {
            job.setId(id);
        } else {
            throw new NotFoundException("not found");
        }
        return JobMapper.MAPPER.fromEntityToResponse(jobRepository.save(job));
    }

    @Override
    public JobResponse get(Integer id) throws NotFoundException {
        Optional<Job> job = jobRepository.findById(id);
        if (job.isPresent()) {
            return JobMapper.MAPPER.fromEntityToResponse(job.get());
        } else {
            throw new NotFoundException("Job not found");
        }
    }

    @Override
    public JobResponse getByName(String name) throws NotFoundException {
        Job job = jobRepository.findByName(name);
        if (job != null) {
            return JobMapper.MAPPER.fromEntityToResponse(job);
        } else {
            throw new NotFoundException("Job not found");
        }
    }

    @Override
    public List<JobResponse> get() throws NotFoundException {
        List<Job> jobs = jobRepository.findAll();
        if (jobs.isEmpty()) {
            throw new NotFoundException("Job not found");
        }
        return JobMapper.MAPPER.fromEntityListToResponse(jobs);
    }

    @Override
    public void delete(Integer id) throws NotFoundException {
        Optional<Job> job = jobRepository.findById(id);
        if (job.isPresent()) {
            jobRepository.delete(job.get());
        } else {
            throw new NotFoundException("Job not found");
        }
    }
}

