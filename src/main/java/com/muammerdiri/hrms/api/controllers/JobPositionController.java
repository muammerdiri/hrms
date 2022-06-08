package com.muammerdiri.hrms.api.controllers;

import com.muammerdiri.hrms.business.abstracts.JobPositionService;
import com.muammerdiri.hrms.entities.concrete.JobPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
@RequestMapping("/api/job-position")
public class JobPositionController {
    private JobPositionService jobPositionService;

    @Autowired
    public JobPositionController(JobPositionService jobPositionService) {
        this.jobPositionService = jobPositionService;
    }

    @GetMapping("/getall")
    public List<JobPosition> getAll(){
        return jobPositionService.getAll();
    }

    @PostMapping("/add")
    public void add(@RequestBody JobPosition jobPosition){
        this.jobPositionService.add(jobPosition);

    }

    @PostMapping("/delete")
    public void delete(@RequestBody JobPosition jobPosition){
        jobPositionService.delete(jobPosition);
    }
}
