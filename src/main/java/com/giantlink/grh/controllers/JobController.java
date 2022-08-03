package com.giantlink.grh.controllers;

import com.giantlink.grh.entities.Job;
import com.giantlink.grh.services.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/company/job")
public class JobController {

    private final JobService jobService;

    @Autowired
    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping("")
    public List<Job> get() {
        return jobService.get();
    }

    @GetMapping("/get/{id}")
public Job get(@PathVariable Integer id) {
        return jobService.get(id);
    }

    @PostMapping("/add")
    public Job add(@RequestBody Job job) {
        return jobService.add(job);
    }

    @PutMapping("/update/{id}")
    public Job update(@PathVariable Integer id, @RequestBody Job job) {
        job.setId(id);
        return jobService.update(id, job);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id) {
        jobService.delete(id);
    }

}
