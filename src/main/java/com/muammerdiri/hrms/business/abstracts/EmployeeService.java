package com.muammerdiri.hrms.business.abstracts;

import com.muammerdiri.hrms.core.utilities.results.DataResult;
import com.muammerdiri.hrms.core.utilities.results.Result;
import com.muammerdiri.hrms.entites.concretes.Employee;
import com.muammerdiri.hrms.entites.concretes.Employer;

import java.util.List;

public interface EmployeeService {
    DataResult<List<Employee>> getAll();
    Result save(Employee employee,String email,String password) throws Exception;



}
