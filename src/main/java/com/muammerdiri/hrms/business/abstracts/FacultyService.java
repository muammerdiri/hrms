package com.muammerdiri.hrms.business.abstracts;

import com.muammerdiri.hrms.core.utilities.results.Result;
import com.muammerdiri.hrms.dataAccess.abstracts.FacultyRepository;
import com.muammerdiri.hrms.entites.concretes.Faculity;

public interface FacultyService {

    Result add(Faculity faculty);

}
