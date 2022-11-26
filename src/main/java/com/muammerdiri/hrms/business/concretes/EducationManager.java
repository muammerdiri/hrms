package com.muammerdiri.hrms.business.concretes;

import com.muammerdiri.hrms.business.abstracts.EducationService;
import com.muammerdiri.hrms.core.utilities.results.DataResult;
import com.muammerdiri.hrms.core.utilities.results.Result;
import com.muammerdiri.hrms.core.utilities.results.SuccessDataResult;
import com.muammerdiri.hrms.core.utilities.results.SuccessResult;
import com.muammerdiri.hrms.dataAccess.abstracts.EducationRepository;
import com.muammerdiri.hrms.entites.concretes.Education;
import com.muammerdiri.hrms.entites.dtos.CreateEducationDto;
import com.muammerdiri.hrms.entites.dtos.GetEducationDetailDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class EducationManager implements EducationService {
    private EducationRepository educationRepository;
    @Autowired
    public EducationManager(EducationRepository educationRepository) {
        this.educationRepository = educationRepository;
    }

    @Override
    public DataResult<List<GetEducationDetailDto>> getEducationByGraduateDate() {
        return new SuccessDataResult<>(educationRepository.getEducationByGraduateDate());
    }


}
