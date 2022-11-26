package com.muammerdiri.hrms.business.concretes;

import com.muammerdiri.hrms.business.abstracts.EmployerService;
import com.muammerdiri.hrms.business.abstracts.UserService;
import com.muammerdiri.hrms.business.responses.GetAllEmployerResponse;
import com.muammerdiri.hrms.core.concretes.User;
import com.muammerdiri.hrms.core.utilities.results.*;
import com.muammerdiri.hrms.dataAccess.abstracts.EmployerRepository;
import com.muammerdiri.hrms.dataAccess.abstracts.UserRepository;
import com.muammerdiri.hrms.entites.concretes.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class EmployerManager implements EmployerService {

    private EmployerRepository employerRepository;
    private UserService userService;


    @Autowired
    public EmployerManager(EmployerRepository employerRepository,UserService userService) {
        this.employerRepository = employerRepository;
        this.userService = userService;
    }

    @Override
    public DataResult<List<GetAllEmployerResponse>> getAll() {

        List<Employer> employers = employerRepository.findAll();
        List<GetAllEmployerResponse> getAllEmployerResponses = new ArrayList<>();
        for (Employer employer:employers){
            GetAllEmployerResponse getAllEmployerResponse = new GetAllEmployerResponse();

            getAllEmployerResponse.setId(employer.getId());
            getAllEmployerResponse.setWebsite(employer.getWebsite());
            getAllEmployerResponse.setEmail(employer.getUser().getEmail());
            getAllEmployerResponse.setCompanyName(employer.getCompanyName());
            getAllEmployerResponse.setPhoneNumber(employer.getPhoneNumber());

            getAllEmployerResponses.add(getAllEmployerResponse);
        }


        return new SuccessDataResult<>(getAllEmployerResponses,"Employer data listed.");
    }

    @Override
    public Result save(Employer employer) {

        employerRepository.save(employer);
        return new SuccessResult("Employer is saved");
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
