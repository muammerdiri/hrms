package com.muammerdiri.hrms.business.abstracts;

import com.muammerdiri.hrms.business.responses.GetAllEmployeeResponse;
import com.muammerdiri.hrms.core.utilities.results.DataResult;
import com.muammerdiri.hrms.core.utilities.results.Result;
import com.muammerdiri.hrms.entites.concretes.Employee;
import com.muammerdiri.hrms.entites.concretes.Employer;
import com.muammerdiri.hrms.entites.dtos.GetEmployeeDetailDto;

import java.util.List;

public interface EmployeeService {
    DataResult<List<GetEmployeeDetailDto>> getAll();
    Result save(Employee employee) throws Exception;



}
