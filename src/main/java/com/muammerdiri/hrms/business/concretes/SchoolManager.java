package com.muammerdiri.hrms.business.concretes;

import com.muammerdiri.hrms.business.abstracts.SchoolService;
import com.muammerdiri.hrms.core.utilities.results.Result;
import com.muammerdiri.hrms.core.utilities.results.SuccessResult;
import com.muammerdiri.hrms.dataAccess.abstracts.SchoolRepository;
import com.muammerdiri.hrms.entites.concretes.School;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SchoolManager implements SchoolService {

    private SchoolRepository schoolRepository;
    @Autowired
    public SchoolManager(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }

    @Override
    public Result add(School school) {
        schoolRepository.save(school);
        return new SuccessResult("School is added.");
    }

}
