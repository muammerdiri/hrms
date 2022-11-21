package com.muammerdiri.hrms.business.abstracts;

import com.muammerdiri.hrms.business.requests.cv.CreateCvRequest;
import com.muammerdiri.hrms.core.utilities.results.DataResult;
import com.muammerdiri.hrms.core.utilities.results.Result;
import com.muammerdiri.hrms.entites.concretes.Cv;

import java.util.List;

public interface CvService {
    Result add(CreateCvRequest cvRequest  );
    DataResult<List<Cv>> getAll();
}
