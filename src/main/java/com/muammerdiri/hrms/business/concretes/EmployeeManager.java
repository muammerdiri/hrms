package com.muammerdiri.hrms.business.concretes;

import com.muammerdiri.hrms.adapters.mernis.GKHKPSPublicSoap;
import com.muammerdiri.hrms.business.abstracts.EmployeeService;
import com.muammerdiri.hrms.business.abstracts.UserService;
import com.muammerdiri.hrms.core.concretes.User;
import com.muammerdiri.hrms.core.utilities.results.*;
import com.muammerdiri.hrms.dataAccess.abstracts.EmployeeRepository;
import com.muammerdiri.hrms.entites.concretes.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public DataResult<List<Employee>> getAll() {
        return new SuccessDataResult<>(employeeRepository.findAll(),"Employee data listed.");
    }

    @Override
    public Result save(Employee employee,String email,String password) throws Exception {

        List<User> users = userService.getAll();
        GKHKPSPublicSoap employeeValidation = new GKHKPSPublicSoap();

        boolean result = employeeValidation.TCKimlikNoDogrula(Long.parseLong(employee.getIdentityNumber()), employee.getFirstName(), employee.getLastName(), employee.getDateOfBirth());

        if (userVerify(users,email))
           return new ErrorResult("Email repetition has occurred. Enter a different email.");
        if (!result)
            return new ErrorResult("Employee not saved. Because identity information is incorrect");


        User user = new User();
        user.setPassword(password);
        user.setEmail(email);
        userService.add(user);

        employee.setUser(user);
        employeeRepository.save(employee);
        return new SuccessResult("Employee saved.");
    }

    private boolean userVerify(List<User> users,String email){
        boolean result=false;
        for (User user: users){
            if(user.getEmail().equals(email))
                result=true;
        }
        return result;
    }



}
