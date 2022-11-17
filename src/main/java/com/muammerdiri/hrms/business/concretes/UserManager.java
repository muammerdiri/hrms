package com.muammerdiri.hrms.business.concretes;

import com.muammerdiri.hrms.business.abstracts.UserService;
import com.muammerdiri.hrms.business.requests.users.CreateUserRequest;
import com.muammerdiri.hrms.business.responses.GetUserResponse;
import com.muammerdiri.hrms.core.concretes.User;
import com.muammerdiri.hrms.core.utilities.results.ErrorResult;
import com.muammerdiri.hrms.core.utilities.results.Result;
import com.muammerdiri.hrms.core.utilities.results.SuccessResult;
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
    public void delete(int id) {
        userRepository.deleteById(id);
    }

    @Override
    public void update(int id, String password) {
        Optional<User> user = userRepository.findById(id);

    }

    @Override
    public GetUserResponse getByEmail(String email) {
        User user = userRepository.findByEmail(email);
        GetUserResponse getUserResponse = new GetUserResponse();

        getUserResponse.setEmail(user.getEmail());
        getUserResponse.setId(user.getId());
        getUserResponse.setPassword(user.getPassword());
        return getUserResponse;
    }

    @Override
    public GetUserResponse getById(int id) {
        Optional<User> user = userRepository.findById(id);
        GetUserResponse getUserResponse = new GetUserResponse();

        getUserResponse.setId(user.get().getId());
        getUserResponse.setPassword(user.get().getPassword());
        getUserResponse.setEmail(user.get().getEmail());

        return getUserResponse;
    }

    @Override
    public User findEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }
}
