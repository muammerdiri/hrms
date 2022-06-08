package com.muammerdiri.hrms.business.abstracts;
import com.muammerdiri.hrms.entities.concrete.JobPosition;

import java.util.*;
public interface JobPositionService {
    List<JobPosition> getAll();
    void add(JobPosition jobPosition);
    void update(JobPosition jobPosition);
    void delete(JobPosition jobPosition);
}
