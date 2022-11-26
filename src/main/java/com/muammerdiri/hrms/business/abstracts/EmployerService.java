package com.muammerdiri.hrms.business.abstracts;

import com.muammerdiri.hrms.business.responses.GetAllEmployerResponse;
import com.muammerdiri.hrms.core.utilities.results.DataResult;
import com.muammerdiri.hrms.core.utilities.results.Result;
import com.muammerdiri.hrms.entites.concretes.Employer;

import java.util.List;

public interface EmployerService {
    DataResult<List<GetAllEmployerResponse>> getAll();
    Result save(Employer employer);
}
