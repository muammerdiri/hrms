package com.muammerdiri.hrms.business.abstracts;

import com.muammerdiri.hrms.business.responses.GetAllJobAdvertisementResponse;
import com.muammerdiri.hrms.core.utilities.results.DataResult;
import com.muammerdiri.hrms.core.utilities.results.Result;
import com.muammerdiri.hrms.entites.concretes.JobAdvertisement;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface JobAdvertisementService {
    DataResult<List<GetAllJobAdvertisementResponse>> getAllByJobAdvertisementWithStatusTrue();
    DataResult<List<GetAllJobAdvertisementResponse>> findAllByLastDate(String date);
    Result add(JobAdvertisement jobAdvertisement);
}
