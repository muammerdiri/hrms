package com.muammerdiri.hrms.webApi.api;

import com.muammerdiri.hrms.business.abstracts.EmployeeService;
import com.muammerdiri.hrms.business.responses.GetAllEmployeeResponse;
import com.muammerdiri.hrms.core.utilities.results.DataResult;
import com.muammerdiri.hrms.core.utilities.results.Result;
import com.muammerdiri.hrms.core.utilities.results.SuccessDataResult;
import com.muammerdiri.hrms.entites.concretes.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/getall")
    public DataResult<List<GetAllEmployeeResponse>> getAll(){
        return employeeService.getAll();
    }

    @PostMapping("/save")
    public Result save(Employee employee,String email,String password) throws Exception {
        return employeeService.save(employee,email,password);
    }

}
