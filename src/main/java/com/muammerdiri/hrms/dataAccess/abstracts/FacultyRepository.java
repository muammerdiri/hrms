package com.muammerdiri.hrms.dataAccess.abstracts;

import com.muammerdiri.hrms.entites.concretes.Faculity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacultyRepository extends JpaRepository<Faculity, Integer> {
}
