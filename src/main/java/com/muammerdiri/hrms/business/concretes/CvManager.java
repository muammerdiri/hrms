package com.muammerdiri.hrms.business.concretes;

import com.muammerdiri.hrms.business.abstracts.CvService;
import com.muammerdiri.hrms.business.abstracts.EducationService;
import com.muammerdiri.hrms.business.abstracts.EmployeeService;
import com.muammerdiri.hrms.business.abstracts.ImageService;
import com.muammerdiri.hrms.business.abstracts.JobExperienceService;
import com.muammerdiri.hrms.business.abstracts.LanguageService;
import com.muammerdiri.hrms.business.abstracts.ProgrammingTechnologyService;
import com.muammerdiri.hrms.core.utilities.results.DataResult;
import com.muammerdiri.hrms.core.utilities.results.ErrorDataResult;
import com.muammerdiri.hrms.core.utilities.results.ErrorResult;
import com.muammerdiri.hrms.core.utilities.results.Result;
import com.muammerdiri.hrms.core.utilities.results.SuccessDataResult;
import com.muammerdiri.hrms.core.utilities.results.SuccessResult;
import com.muammerdiri.hrms.dataAccess.abstracts.CvRepository;
import com.muammerdiri.hrms.entites.concretes.Cv;
import com.muammerdiri.hrms.entites.concretes.Education;
import com.muammerdiri.hrms.entites.concretes.Employee;
import com.muammerdiri.hrms.entites.concretes.Image;
import com.muammerdiri.hrms.entites.concretes.JobExperience;
import com.muammerdiri.hrms.entites.concretes.Language;
import com.muammerdiri.hrms.entites.concretes.ProgrammingTechnology;
import com.muammerdiri.hrms.entites.dtos.CreateCvDto;
import com.muammerdiri.hrms.entites.dtos.GetCvDetailDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class  CvManager implements CvService {

    private CvRepository cvRepository;
    private EducationService educationService;
    private ImageService imageService;
    private ProgrammingTechnologyService programmingTechnologyService;
    private JobExperienceService jobExperienceService;
    private LanguageService languageService; 
    private EmployeeService employeeService;

    @Autowired
	public CvManager(CvRepository cvRepository, EducationService educationService, ImageService imageService,
			ProgrammingTechnologyService programmingTechnologyService, JobExperienceService jobExperienceService,
			LanguageService languageService,EmployeeService employeeService) {
	
		this.cvRepository = cvRepository;
		this.educationService = educationService;
		this.imageService = imageService;
		this.programmingTechnologyService = programmingTechnologyService;
		this.jobExperienceService = jobExperienceService;
		this.languageService = languageService;
		this.employeeService=employeeService;
	}
    
    
    @Override
    public DataResult<List<GetCvDetailDto>> getAll() {
        return new SuccessDataResult<>(cvRepository.getAll(),"Cvs listed.");
    }





	@Override
	public Result save(CreateCvDto createCvDto) {
		Education education = educationService.findById(createCvDto.getEducationId());
		Image image = imageService.findById(createCvDto.getImageId());
		JobExperience jobExperience = jobExperienceService.findById(createCvDto.getJobExperienceId());
		ProgrammingTechnology programmingTechnology = programmingTechnologyService.findById(createCvDto.getProgrammingTechnologyId());
		Language language = languageService.findById(createCvDto.getLanguageId());
		Employee employee = employeeService.findById(createCvDto.getEmployeeId());
		
		if(education==null||image==null||jobExperience==null||programmingTechnology==null||language==null||employee==null)
			return new ErrorResult("Cv not saved.");
		
		Cv cv = new Cv();
		cv.setCoverLetter(createCvDto.getCoverLetter());
		cv.setEducation(education);
		cv.setGithubAccount(createCvDto.getGithubAccount());
		cv.setImage(image);
		cv.setJobExperience(jobExperience);
		cv.setLanguage(language);
		cv.setLinkedInAccount(createCvDto.getLinkedInAccount());
		cv.setProgrammingTechnology(programmingTechnology);
		cv.setEmployee(employee);
		cvRepository.save(cv);			
		return new SuccessResult("CV is saved. :-) ");
	}


	@Override
	public DataResult<List<GetCvDetailDto>> getListbyUserId(int userId) {
		List<GetCvDetailDto> found = cvRepository.findByEmployeeId(userId);
		if(found.isEmpty())
			return new ErrorDataResult<>("Data not found.");
		return new SuccessDataResult<>(found,"Data listed.");
	}
}
