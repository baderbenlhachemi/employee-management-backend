package com.giantlink.grh.controllers;

import com.giantlink.grh.dto.request.JobRequest;
import com.giantlink.grh.dto.response.JobResponse;
import com.giantlink.grh.exceptions.AlreadyExistsException;
import com.giantlink.grh.exceptions.NotFoundException;
import com.giantlink.grh.services.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public List<JobResponse> get() throws NotFoundException {
        return jobService.get();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<JobResponse> get(@PathVariable Integer id) throws NotFoundException {
        return new ResponseEntity<JobResponse>(jobService.get(id), HttpStatus.OK);
    }

    @GetMapping("/getname/{name}")
    public ResponseEntity<JobResponse> getByName(@PathVariable String name) throws NotFoundException {
        return new ResponseEntity<JobResponse>(jobService.getByName(name), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<JobResponse> add(@RequestBody @Valid JobRequest jobRequest) throws AlreadyExistsException {
        return new ResponseEntity<JobResponse>(jobService.add(jobRequest), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<JobResponse> update(@PathVariable Integer id, @RequestBody @Valid JobRequest jobRequest) throws AlreadyExistsException, NotFoundException {
        return new ResponseEntity<JobResponse>(jobService.update(id, jobRequest), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id) throws NotFoundException {
        jobService.delete(id);
    }

}
