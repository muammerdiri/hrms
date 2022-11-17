package com.muammerdiri.hrms.dataAccess.abstracts;

import com.muammerdiri.hrms.core.concretes.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findByEmail(String email);
}
