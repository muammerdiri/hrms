package com.muammerdiri.hrms.webApi.api;

import com.muammerdiri.hrms.business.abstracts.CvService;
import com.muammerdiri.hrms.business.requests.cv.CreateCvRequest;
import com.muammerdiri.hrms.core.utilities.results.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cvs")
public class CvController {

    private CvService cvService;
    @Autowired
    public CvController(CvService cvService) {
        this.cvService = cvService;
    }


    @PostMapping("/save")
    public Result save(  CreateCvRequest cvRequest ){
        return cvService.add(cvRequest);
    }



}
