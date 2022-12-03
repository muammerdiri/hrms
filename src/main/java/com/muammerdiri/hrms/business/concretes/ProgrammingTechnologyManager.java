package com.muammerdiri.hrms.business.concretes;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.muammerdiri.hrms.business.abstracts.ProgrammingTechnologyService;
import com.muammerdiri.hrms.dataAccess.abstracts.ProgrammingTechnologyRepository;
import com.muammerdiri.hrms.entites.concretes.ProgrammingTechnology;
@Service
public class ProgrammingTechnologyManager implements ProgrammingTechnologyService {

	private ProgrammingTechnologyRepository programmingTechnologyRepository;
	   @Autowired
	public ProgrammingTechnologyManager(ProgrammingTechnologyRepository programmingTechnologyRepository) {
		super();
		this.programmingTechnologyRepository = programmingTechnologyRepository;
	}

	@Override
	public ProgrammingTechnology findById(int id) {
		Optional<ProgrammingTechnology> foundProgrammingTechnology = programmingTechnologyRepository.findById(id);
		ProgrammingTechnology programmingTechnology = foundProgrammingTechnology.get();
		return programmingTechnology;
	}
	
}
