package com.muammerdiri.hrms.business.concretes;

import com.muammerdiri.hrms.business.abstracts.JobAdvertisementService;
import com.muammerdiri.hrms.business.responses.GetAllJobAdvertisementResponse;
import com.muammerdiri.hrms.core.utilities.results.DataResult;
import com.muammerdiri.hrms.core.utilities.results.Result;
import com.muammerdiri.hrms.core.utilities.results.SuccessDataResult;
import com.muammerdiri.hrms.dataAccess.abstracts.JobAdvertisementRepository;
import com.muammerdiri.hrms.entites.concretes.JobAdvertisement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {

    private JobAdvertisementRepository jobAdvertisementRepository;

    @Autowired
    public JobAdvertisementManager(JobAdvertisementRepository jobAdvertisementRepository) {
        this.jobAdvertisementRepository = jobAdvertisementRepository;
    }

    @Override
    public DataResult<List<GetAllJobAdvertisementResponse>> getAllByJobAdvertisementWithStatusTrue() {

        List<JobAdvertisement> jobAdvertisementList = jobAdvertisementRepository.findAllByStatusTrue();
        List<GetAllJobAdvertisementResponse> getAllJobAdvertisementResponseList = new ArrayList<>();
        for (JobAdvertisement jobAdvertisement:jobAdvertisementList){
            GetAllJobAdvertisementResponse getAllJobAdvertisementResponse = new GetAllJobAdvertisementResponse();

            getAllJobAdvertisementResponse.setJobPosition(jobAdvertisement.getJobPosition().getName());
            getAllJobAdvertisementResponse.setTitle(jobAdvertisement.getTitle());
            getAllJobAdvertisementResponse.setNumberOfPosition(jobAdvertisement.getNumberOfPosition());
            getAllJobAdvertisementResponse.setReleaseDate(jobAdvertisement.getReleaseDate());
            getAllJobAdvertisementResponse.setLastDate(jobAdvertisement.getLastDate());

            getAllJobAdvertisementResponseList.add(getAllJobAdvertisementResponse);
        }

        return new SuccessDataResult<>(getAllJobAdvertisementResponseList,"Job Advertisement listed.");
    }

    @Override
    public DataResult<List<GetAllJobAdvertisementResponse>> findAllByLastDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
        LocalDate localDate = LocalDate.parse(date, formatter);

        List<JobAdvertisement> jobAdvertisementList = jobAdvertisementRepository.findAllByLastDate(localDate);
        List<GetAllJobAdvertisementResponse> getAllJobAdvertisementResponses = new ArrayList<>();
        for (JobAdvertisement jobAdvertisement:jobAdvertisementList){
            GetAllJobAdvertisementResponse getAllJobAdvertisementResponse = new GetAllJobAdvertisementResponse();

            getAllJobAdvertisementResponse.setJobPosition(jobAdvertisement.getJobPosition().getName());
            getAllJobAdvertisementResponse.setTitle(jobAdvertisement.getTitle());
            getAllJobAdvertisementResponse.setNumberOfPosition(jobAdvertisement.getNumberOfPosition());
            getAllJobAdvertisementResponse.setReleaseDate(jobAdvertisement.getReleaseDate());
            getAllJobAdvertisementResponse.setLastDate(jobAdvertisement.getLastDate());

            getAllJobAdvertisementResponses.add(getAllJobAdvertisementResponse);
        }

        return new SuccessDataResult<>(getAllJobAdvertisementResponses,"Job Advertisement listed.");
    }

    @Override
    public Result add(JobAdvertisement jobAdvertisement) {
        return null;
    }
}
