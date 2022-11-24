package com.muammerdiri.hrms.business.abstracts;

import com.muammerdiri.hrms.core.utilities.results.DataResult;
import com.muammerdiri.hrms.core.utilities.results.Result;
import com.muammerdiri.hrms.entites.concretes.JobAdvertisement;
import com.muammerdiri.hrms.entites.dtos.GetJobAdvertisementDetailsDto;

import java.util.List;

public interface JobAdvertisementService {
    DataResult<List<GetJobAdvertisementDetailsDto>> findAllByLastDate(String date);
    Result add(JobAdvertisement jobAdvertisement);
    DataResult<List<GetJobAdvertisementDetailsDto>> getJobAdvertisementWithCityAndJobPositionDto();
}
