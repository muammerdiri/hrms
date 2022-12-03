package com.muammerdiri.hrms.webApi.api;

import com.muammerdiri.hrms.business.abstracts.EducationService;
import com.muammerdiri.hrms.core.utilities.results.DataResult;
import com.muammerdiri.hrms.core.utilities.results.Result;
import com.muammerdiri.hrms.dataAccess.abstracts.EducationRepository;
import com.muammerdiri.hrms.entites.dtos.CreateEducationDto;
import com.muammerdiri.hrms.entites.dtos.GetEducationDetailDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/educations")
public class EducationController {
    private EducationService educationService;

    @Autowired
    public EducationController(EducationService educationService, EducationRepository educationRepository) {
        this.educationService = educationService;
    }


    @GetMapping("/getEducationByGraduateDate")
    public DataResult<List<GetEducationDetailDto>> getEducationByGraduateDate() {
        return educationService.getEducationByGraduateDate();
    }


    @PostMapping("/add")
    public Result add(CreateEducationDto createEducationDto){
   
        return educationService.save(createEducationDto);
    }

}
