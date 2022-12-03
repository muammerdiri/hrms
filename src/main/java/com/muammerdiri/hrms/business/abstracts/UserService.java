package com.muammerdiri.hrms.business.abstracts;


import com.muammerdiri.hrms.core.concretes.User;
import com.muammerdiri.hrms.core.utilities.results.DataResult;
import com.muammerdiri.hrms.core.utilities.results.Result;



public interface UserService {
    Result add(User user);
    DataResult<User> findEmail(String email);

}
