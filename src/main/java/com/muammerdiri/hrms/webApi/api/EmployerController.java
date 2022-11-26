package com.muammerdiri.hrms.webApi.api;

import com.muammerdiri.hrms.business.abstracts.EmployerService;
import com.muammerdiri.hrms.business.responses.GetAllEmployerResponse;
import com.muammerdiri.hrms.core.utilities.results.DataResult;
import com.muammerdiri.hrms.core.utilities.results.Result;
import com.muammerdiri.hrms.entites.concretes.Employer;
import com.muammerdiri.hrms.entites.dtos.GetEmployerDetailDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/employers")
public class EmployerController {

    private EmployerService employerService;

    @Autowired
    public EmployerController(EmployerService employerService) {
        this.employerService = employerService;
    }


    @GetMapping("/getall")
    public DataResult<List<GetEmployerDetailDto>> getAll(){
        return employerService.getAll();
    }

    @PostMapping("/save")
    public Result save(Employer employer){
        return  employerService.save(employer);
    }
}
