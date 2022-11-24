package com.muammerdiri.hrms.business.concretes;

import com.muammerdiri.hrms.business.abstracts.JobAdvertisementService;
import com.muammerdiri.hrms.core.utilities.results.DataResult;
import com.muammerdiri.hrms.core.utilities.results.Result;
import com.muammerdiri.hrms.core.utilities.results.SuccessDataResult;
import com.muammerdiri.hrms.dataAccess.abstracts.JobAdvertisementRepository;
import com.muammerdiri.hrms.entites.concretes.JobAdvertisement;
import com.muammerdiri.hrms.entites.dtos.GetJobAdvertisementDetailsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {

    private JobAdvertisementRepository jobAdvertisementRepository;

    @Autowired
    public JobAdvertisementManager(JobAdvertisementRepository jobAdvertisementRepository) {
        this.jobAdvertisementRepository = jobAdvertisementRepository;
    }


    @Override
    public DataResult<List<GetJobAdvertisementDetailsDto>> findAllByLastDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
        LocalDate localDate = LocalDate.parse(date, formatter);
        return new SuccessDataResult<>(jobAdvertisementRepository.findAllByLastDate(localDate),"Job Advertisement listed.");
    }

    @Override
    public Result add(JobAdvertisement jobAdvertisement) {
        return null;
    }

    @Override
    public DataResult<List<GetJobAdvertisementDetailsDto>> getJobAdvertisementWithCityAndJobPositionDto() {
        return new SuccessDataResult<>(jobAdvertisementRepository.getJobAdvertisementWithCityAndPosition());
    }
}
