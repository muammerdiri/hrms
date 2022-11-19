package com.muammerdiri.hrms.webApi.api;

import com.muammerdiri.hrms.business.abstracts.JobAdvertisementService;
import com.muammerdiri.hrms.business.responses.GetAllJobAdvertisementResponse;
import com.muammerdiri.hrms.core.utilities.results.DataResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/job-advertisements")
public class JobAdvertisementController {

    private JobAdvertisementService jobAdvertisementService;

    public JobAdvertisementController(JobAdvertisementService jobAdvertisementService) {
        this.jobAdvertisementService = jobAdvertisementService;
    }

    @GetMapping("/get-all-by-job-advertisement-with-status-true")
    public DataResult<List<GetAllJobAdvertisementResponse>> getAllByJobAdvertisementWithStatusTrue() {
        return jobAdvertisementService.getAllByJobAdvertisementWithStatusTrue();
    }

    @GetMapping("/find-all-by-last-date")
    public DataResult<List<GetAllJobAdvertisementResponse>> findAllByLastDate(String date) {
        return jobAdvertisementService.findAllByLastDate(date);
    }
}
