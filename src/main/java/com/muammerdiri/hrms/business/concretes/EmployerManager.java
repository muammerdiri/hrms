package com.muammerdiri.hrms.business.concretes;

import com.muammerdiri.hrms.business.abstracts.EmployerService;
import com.muammerdiri.hrms.core.concretes.User;
import com.muammerdiri.hrms.core.utilities.results.*;
import com.muammerdiri.hrms.dataAccess.abstracts.EmployerRepository;
import com.muammerdiri.hrms.dataAccess.abstracts.UserRepository;
import com.muammerdiri.hrms.entites.concretes.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployerManager implements EmployerService {

    private EmployerRepository employerRepository;
    private UserRepository userRepository;


    @Autowired
    public EmployerManager(EmployerRepository employerRepository) {
        this.employerRepository = employerRepository;
    }

    @Override
    public DataResult<List<Employer>> getAll() {
        return new SuccessDataResult<>(employerRepository.findAll(),"Employer data listed.");
    }

    @Override
    public Result save(Employer employer, String email, String password) {
        List<User> users = userRepository.findAll();
        for(User user:users){
            if(userVerify(users,email))
                return new ErrorResult("Email repetition has occurred. Enter a different email.");
        }
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        userRepository.save(user);

        employer.setUser(user);
        employerRepository.save(employer);

        return new SuccessResult("Employer is saved");
    }

    private boolean userVerify(List<User> users, String email){
        boolean result=false;
        for (User user: users){
            if(user.getEmail().equals(email))
                return result;

        }
        result = true;
        return result;
    }
}
