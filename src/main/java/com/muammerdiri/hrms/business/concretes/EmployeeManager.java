package com.muammerdiri.hrms.business.concretes;

import com.muammerdiri.hrms.adapters.mernis.GKHKPSPublicSoap;
import com.muammerdiri.hrms.business.abstracts.EmployeeService;

import com.muammerdiri.hrms.core.utilities.results.*;
import com.muammerdiri.hrms.dataAccess.abstracts.EmployeeRepository;
import com.muammerdiri.hrms.entites.concretes.Employee;
import com.muammerdiri.hrms.entites.dtos.GetEmployeeDetailDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
@Service
public class EmployeeManager implements EmployeeService {


    private final EmployeeRepository employeeRepository;


    @Autowired
    public EmployeeManager(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
     
    }

    @Override
    public DataResult<List<GetEmployeeDetailDto>> getAll() {

        return new SuccessDataResult<>(employeeRepository.getAll(),"Employee data listed.");
    }

    @Override
    public Result save(Employee employee) throws Exception {

        GKHKPSPublicSoap employeeValidation = new GKHKPSPublicSoap();
        boolean result = employeeValidation.TCKimlikNoDogrula(Long.parseLong(employee.getIdentityNumber()), employee.getFirstName(), employee.getLastName(), employee.getDateOfBirth());

        if (!result)
            return new ErrorResult("Employee not saved. Because identity information is incorrect");

        employeeRepository.save(employee);
        return new SuccessResult("Employee saved.");
    }

	@Override
	public Employee findById(int id) {
		
		Optional<Employee> foundEmployee=employeeRepository.findById(id);
		Employee employee = foundEmployee.get();
		
		return employee;
	}





}
