package com.muammerdiri.hrms.business.concretes;

import com.muammerdiri.hrms.business.abstracts.DepartmentService;
import com.muammerdiri.hrms.core.utilities.results.DataResult;
import com.muammerdiri.hrms.core.utilities.results.Result;
import com.muammerdiri.hrms.core.utilities.results.SuccessDataResult;
import com.muammerdiri.hrms.core.utilities.results.SuccessResult;
import com.muammerdiri.hrms.dataAccess.abstracts.DepartmentRepository;
import com.muammerdiri.hrms.entites.concretes.Department;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentManager implements DepartmentService {

    private DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentManager(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public Result add(Department department) {
        departmentRepository.save(department);
        return new SuccessResult("Department is saved.");
    }

	@Override
	public DataResult<Department> findById(int id) {
		
		Optional<Department> foundDepartment= departmentRepository.findById(id);
		Department department=foundDepartment.get();
		return new SuccessDataResult<>(department);
	}
	
	@Override
	public Optional<Department> findByDepartmentId(int id) {
		return departmentRepository.findById(id);
	}
}
