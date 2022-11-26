package com.muammerdiri.hrms.business.concretes;

import com.muammerdiri.hrms.adapters.mernis.GKHKPSPublicSoap;
import com.muammerdiri.hrms.business.abstracts.EmployeeService;
import com.muammerdiri.hrms.business.abstracts.UserService;
import com.muammerdiri.hrms.business.responses.GetAllEmployeeResponse;
import com.muammerdiri.hrms.core.concretes.User;
import com.muammerdiri.hrms.core.utilities.results.*;
import com.muammerdiri.hrms.dataAccess.abstracts.EmployeeRepository;
import com.muammerdiri.hrms.entites.concretes.Employee;
import com.muammerdiri.hrms.entites.dtos.GetEmployeeDetailDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class EmployeeManager implements EmployeeService {


    private final EmployeeRepository employeeRepository;
    private final UserService userService;

    @Autowired
    public EmployeeManager(EmployeeRepository employeeRepository ,UserService userService) {
        this.employeeRepository = employeeRepository;
        this.userService = userService;
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





}
