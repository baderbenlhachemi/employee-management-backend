package com.giantlink.grh.services;

import com.giantlink.grh.entities.Job;

import java.util.List;

public interface JobService {

    Job add(Job job);

    Job update(Integer id, Job job);

    Job get(Integer id);

    Job get(String name);

    List<Job> get();

    void delete(Integer id);

}
