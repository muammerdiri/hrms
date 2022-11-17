package com.muammerdiri.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.muammerdiri.hrms.entites.concretes.JobPosition;

public interface JobPositionRepository extends JpaRepository<JobPosition, Integer>{

}
