package com.muammerdiri.hrms.business.concretes;

import com.muammerdiri.hrms.business.abstracts.CvService;
import com.muammerdiri.hrms.business.requests.cv.CreateCvRequest;
import com.muammerdiri.hrms.core.utilities.results.DataResult;
import com.muammerdiri.hrms.core.utilities.results.Result;
import com.muammerdiri.hrms.core.utilities.results.SuccessResult;
import com.muammerdiri.hrms.dataAccess.abstracts.CvRepository;
import com.muammerdiri.hrms.entites.concretes.Cv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
@Service
public class CvManager implements CvService {

    private CvRepository cvRepository;

    @Autowired
    public CvManager(CvRepository cvRepository) {
        this.cvRepository = cvRepository;
    }

    @Override
    public Result add(CreateCvRequest cvRequest) {

        Cv cv = new Cv();

        // Employee
        cv.getEmployee().setId(2);
        cv.getEmployee().setFirstName(cvRequest.getFirstName());
        cv.getEmployee().setLastName(cvRequest.getLastName());
        cv.getEmployee().setDateOfBirth(cvRequest.getDateOfBirth());
        cv.getEmployee().setIdentityNumber(cvRequest.getIdentityNumber());

        // CV
        cv.setCoverLetter(cv.getCoverLetter());
        cv.setLinkedInAccount(cvRequest.getLinkedInAccount());
        cv.setGithubAccount(cvRequest.getGithubAccount());

        // School
        cv.getSchool().setName(cvRequest.getSchoolName());
        cv.getSchool().setDepartment(cvRequest.getSchoolDepartment());
        cv.getSchool().setEnterDate(stringToLocalDate(cvRequest.getSchoolEnterDate()));
        cv.getSchool().setGraduateDate(stringToLocalDate(cvRequest.getGraduateDate()));
        cv.getSchool().getEmployee().setId(cvRequest.getEmployeeId());

        //JobExperience
        cv.getJobExperience().setCompanyName(cvRequest.getCompanyName());
        cv.getJobExperience().getJobPosition().setName(cvRequest.getPositionName());
        cv.getJobExperience().setEnterDate(stringToLocalDate(cvRequest.getJobEnterDate()));
        cv.getJobExperience().setFinishDate(stringToLocalDate(cvRequest.getJobFinishDate()));
        cv.getJobExperience().getEmployee().setId(cvRequest.getEmployeeId());

        //Language
        cv.getLanguage().setName(cvRequest.getLanguageName());
        cv.getLanguage().setLevel(cvRequest.getLanguageLevel());
        cv.getLanguage().getEmployee().setId(cvRequest.getEmployeeId());

        // ProgrammingTechnology
        cv.getProgrammingTechnology().getProgrammingLanguage().setName(cvRequest.getProgrammingName());
        cv.getProgrammingTechnology().setName(cvRequest.getProgrammingTechnonlogy());
        cv.getProgrammingTechnology().getEmployee().setId(cvRequest.getEmployeeId());

        //Image
        cv.getImage().setImageName(cvRequest.getImageName());
        cv.getImage().setPath(cvRequest.getImagePath());
        cv.getImage().setCreatedDate(stringToLocalDate(cvRequest.getImageCreateDate()));
        cv.getImage().getEmployee().setId(cvRequest.getEmployeeId());
        cvRepository.save(cv);

        return new SuccessResult("Cv is added.");
    }

    @Override
    public DataResult<List<Cv>> getAll() {
        return null;
    }


    private LocalDate stringToLocalDate(String date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/d");
        LocalDate localDate = LocalDate.parse(date, formatter);
        return localDate;
    }
}
