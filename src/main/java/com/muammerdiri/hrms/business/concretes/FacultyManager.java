package com.muammerdiri.hrms.business.concretes;

import com.muammerdiri.hrms.business.abstracts.FacultyService;
import com.muammerdiri.hrms.core.utilities.results.Result;
import com.muammerdiri.hrms.core.utilities.results.SuccessResult;
import com.muammerdiri.hrms.dataAccess.abstracts.FacultyRepository;
import com.muammerdiri.hrms.entites.concretes.Faculity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FacultyManager implements FacultyService {

    private FacultyRepository facultyRepository;
    @Autowired
    public FacultyManager(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    @Override
    public Result add(Faculity faculty) {
        facultyRepository.save(faculty);
        return new SuccessResult("Faculty is added.");
    }
}
