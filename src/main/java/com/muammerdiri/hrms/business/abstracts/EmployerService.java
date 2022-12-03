package com.muammerdiri.hrms.business.abstracts;

import com.muammerdiri.hrms.core.utilities.results.DataResult;
import com.muammerdiri.hrms.core.utilities.results.Result;
import com.muammerdiri.hrms.entites.concretes.Employer;
import com.muammerdiri.hrms.entites.dtos.GetEmployerDetailDto;

import java.util.List;

public interface EmployerService {
    DataResult<List<GetEmployerDetailDto>> getAll();
    Result save(Employer employer);
}
