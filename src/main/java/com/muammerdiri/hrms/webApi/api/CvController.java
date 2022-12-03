package com.muammerdiri.hrms.webApi.api;

import com.muammerdiri.hrms.business.abstracts.CvService;
import com.muammerdiri.hrms.core.utilities.results.DataResult;
import com.muammerdiri.hrms.core.utilities.results.Result;
import com.muammerdiri.hrms.entites.dtos.CreateCvDto;
import com.muammerdiri.hrms.entites.dtos.GetCvDetailDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/cvs")
public class CvController {

    private CvService cvService;
    @Autowired
    public CvController(CvService cvService) {
        this.cvService = cvService;
    }

    @GetMapping("/getall")
    public DataResult<List<GetCvDetailDto>> getAll(){
        return cvService.getAll();
    }
    
    @PostMapping
    public Result save(CreateCvDto cv) {
    	return cvService.save(cv);
    }
    
    
    
    

}
