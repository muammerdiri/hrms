package com.muammerdiri.hrms.business.abstracts;

import java.util.Optional;

import com.muammerdiri.hrms.core.utilities.results.DataResult;
import com.muammerdiri.hrms.core.utilities.results.Result;
import com.muammerdiri.hrms.entites.concretes.Department;

public interface DepartmentService {

    Result add(Department department);
    DataResult<Department> findById(int id);
    Optional<Department> findByDepartmentId(int id);

}
