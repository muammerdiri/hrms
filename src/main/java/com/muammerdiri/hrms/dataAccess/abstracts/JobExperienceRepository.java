package com.muammerdiri.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.muammerdiri.hrms.entites.concretes.JobExperience;

public interface JobExperienceRepository extends JpaRepository<JobExperience, Integer>{

}
