package com.muammerdiri.hrms.business.concretes;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.muammerdiri.hrms.business.abstracts.JobExperienceService;
import com.muammerdiri.hrms.dataAccess.abstracts.JobExperienceRepository;
import com.muammerdiri.hrms.entites.concretes.JobExperience;

@Service
public class JobExperienceManager implements JobExperienceService {

	private JobExperienceRepository jobExperienceRepository;

	   @Autowired
	public JobExperienceManager(JobExperienceRepository jobExperienceRepository) {
		super();
		this.jobExperienceRepository = jobExperienceRepository;
	}

	@Override
	public JobExperience findById(int id) {
		Optional<JobExperience> foundJobExperience=jobExperienceRepository.findById(id);
		JobExperience jobExperience = foundJobExperience.get();
		return jobExperience;
	}
	
	
	
}
