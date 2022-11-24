package com.muammerdiri.hrms.business.concretes;

import com.muammerdiri.hrms.business.abstracts.CvService;
import com.muammerdiri.hrms.core.utilities.results.DataResult;
import com.muammerdiri.hrms.core.utilities.results.SuccessDataResult;
import com.muammerdiri.hrms.dataAccess.abstracts.CvRepository;
import com.muammerdiri.hrms.entites.dtos.GetCvDetailDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CvManager implements CvService {

    private CvRepository cvRepository;

    @Autowired
    public CvManager(CvRepository cvRepository) {
        this.cvRepository = cvRepository;
    }


    @Override
    public DataResult<List<GetCvDetailDto>> getAll() {
        return new SuccessDataResult<>(cvRepository.getAll(),"Cvs listed.");
    }
}
