package com.muammerdiri.hrms.business.abstracts;

import com.muammerdiri.hrms.business.requests.CreateJobPositionRequest;
import com.muammerdiri.hrms.business.requests.users.CreateUserRequest;
import com.muammerdiri.hrms.business.responses.GetUserResponse;
import com.muammerdiri.hrms.core.concretes.User;
import com.muammerdiri.hrms.core.utilities.results.Result;

import java.util.List;

public interface UserService {
    Result add(User user);
    void delete(int id);
    void update(int id,String password);
    GetUserResponse getByEmail(String email);
    GetUserResponse getById(int id);

    User findEmail(String email);
    List<User> getAll();
}
