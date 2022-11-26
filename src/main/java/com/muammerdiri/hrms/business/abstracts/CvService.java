package com.muammerdiri.hrms.business.abstracts;

import com.muammerdiri.hrms.core.utilities.results.DataResult;
import com.muammerdiri.hrms.entites.dtos.GetCvDetailDto;

import java.util.List;

public interface CvService {
    DataResult<List<GetCvDetailDto>> getAll();
}