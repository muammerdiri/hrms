package com.muammerdiri.hrms.business.concretes;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.muammerdiri.hrms.business.abstracts.DepartmentService;
import com.muammerdiri.hrms.business.abstracts.EducationService;
import com.muammerdiri.hrms.core.utilities.results.DataResult;
import com.muammerdiri.hrms.core.utilities.results.ErrorDataResult;
import com.muammerdiri.hrms.core.utilities.results.Result;
import com.muammerdiri.hrms.core.utilities.results.SuccessDataResult;
import com.muammerdiri.hrms.core.utilities.results.SuccessResult;
import com.muammerdiri.hrms.dataAccess.abstracts.EducationRepository;
import com.muammerdiri.hrms.entites.concretes.Department;
import com.muammerdiri.hrms.entites.concretes.Education;
import com.muammerdiri.hrms.entites.dtos.CreateEducationDto;
import com.muammerdiri.hrms.entites.dtos.GetEducationDetailDto;

@Service
public class EducationManager implements EducationService {
    
	private EducationRepository educationRepository;
    private DepartmentService departmentService;
    
    
    @Autowired
    public EducationManager(EducationRepository educationRepository,DepartmentService departmentService) {
        this.educationRepository = educationRepository;
        this.departmentService = departmentService;
    }

    @Override
    public DataResult<List<GetEducationDetailDto>> getEducationByGraduateDate() {
        return new SuccessDataResult<>(educationRepository.getEducationByGraduateDate());
    }

    @Override
    public Result save(CreateEducationDto createEducationDto) {
    	Optional<Department> department = departmentService.findByDepartmentId(createEducationDto.getDepartmentId());
    	if(department.isPresent()) {
    		Education education = new Education();

    		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-d");
    		
    		LocalDate dateOfEntry = LocalDate.parse(createEducationDto.getDateOfEntry(), formatter);
    		LocalDate graduateDate = LocalDate.parse(createEducationDto.getGraduateDate(), formatter);

    		
    		
    		education.setScore(createEducationDto.getScore());
    		education.setDepartment(department.get());
    		education.setDateOfEntry(dateOfEntry);
    		education.setGraduateDate(graduateDate);
    		
    		educationRepository.save(education);
            return new SuccessResult("Edu is added.");
    	}
    	return new ErrorDataResult<>("Edu cannot add.");
    }

	@Override
	public Education findById(int id) {
		Optional<Education> foundEdu =educationRepository.findById(id);
		Education education = foundEdu.get();
		return education;
	}
    



}














