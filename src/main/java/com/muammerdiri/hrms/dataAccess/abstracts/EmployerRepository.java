package com.muammerdiri.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.muammerdiri.hrms.entites.concretes.Employer;

public interface EmployerRepository extends JpaRepository<Employer, Integer>{

}
