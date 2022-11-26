package com.muammerdiri.hrms.business.concretes;

import com.muammerdiri.hrms.business.abstracts.UserService;
import com.muammerdiri.hrms.business.requests.users.CreateUserRequest;
import com.muammerdiri.hrms.business.responses.GetUserResponse;
import com.muammerdiri.hrms.core.concretes.User;
import com.muammerdiri.hrms.core.utilities.results.*;
import com.muammerdiri.hrms.dataAccess.abstracts.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class UserManager implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserManager(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public Result add(User user) {
        userRepository.save(user);
        return new SuccessResult("User is saved.");
    }

    @Override
    public DataResult<User> findEmail(String email) {
        return new SuccessDataResult<>(userRepository.findByEmail(email),"User is finded.");
    }


}
