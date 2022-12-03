package com.muammerdiri.hrms.business.concretes;

import com.muammerdiri.hrms.business.abstracts.EmployerService;

import com.muammerdiri.hrms.core.utilities.results.*;
import com.muammerdiri.hrms.dataAccess.abstracts.EmployerRepository;
import com.muammerdiri.hrms.entites.concretes.Employer;
import com.muammerdiri.hrms.entites.dtos.GetEmployerDetailDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public class EmployerManager implements EmployerService {

    private EmployerRepository employerRepository;



    @Autowired
    public EmployerManager(EmployerRepository employerRepository ) {
        this.employerRepository = employerRepository;

    }

    @Override
    public DataResult<List<GetEmployerDetailDto>> getAll() {
                return new SuccessDataResult<>(employerRepository.getAll(),"Employer data listed.");
    }

    @Override
    public Result save(Employer employer) {

        employerRepository.save(employer);
        return new SuccessResult("Employer is saved");
    }

}
