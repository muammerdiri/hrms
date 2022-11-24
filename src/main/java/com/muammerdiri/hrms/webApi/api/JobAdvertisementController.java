package com.muammerdiri.hrms.webApi.api;

import com.muammerdiri.hrms.business.abstracts.JobAdvertisementService;
import com.muammerdiri.hrms.core.utilities.results.DataResult;
import com.muammerdiri.hrms.entites.dtos.GetJobAdvertisementDetailsDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/job-advertisements")
public class JobAdvertisementController {

    private JobAdvertisementService jobAdvertisementService;

    public JobAdvertisementController(JobAdvertisementService jobAdvertisementService) {
        this.jobAdvertisementService = jobAdvertisementService;
    }



    @GetMapping("/findAllByLastDate")
    public DataResult<List<GetJobAdvertisementDetailsDto>> findAllByLastDate(String date) {
        return jobAdvertisementService.findAllByLastDate(date);
    }

    @GetMapping("/get-all-by-job-advertisement-with-status-true")
    public DataResult<List<GetJobAdvertisementDetailsDto>> getJobAdvertisementWithCityAndJobPositionDto(){
        return jobAdvertisementService.getJobAdvertisementWithCityAndJobPositionDto();
    }
}
