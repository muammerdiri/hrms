package com.muammerdiri.hrms.business.abstracts;

import com.muammerdiri.hrms.core.utilities.results.DataResult;
import com.muammerdiri.hrms.core.utilities.results.Result;
import com.muammerdiri.hrms.entites.concretes.Education;
import com.muammerdiri.hrms.entites.dtos.CreateEducationDto;
import com.muammerdiri.hrms.entites.dtos.GetEducationDetailDto;

import java.util.List;

public interface EducationService {
    DataResult<List<GetEducationDetailDto>> getEducationByGraduateDate();
    Result save(CreateEducationDto createEducationDto);
    Education findById(int id); 
}
