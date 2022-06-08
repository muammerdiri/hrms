package com.muammerdiri.hrms.business.concrete;

import com.muammerdiri.hrms.business.abstracts.JobPositionService;
import com.muammerdiri.hrms.dataAccess.abstracts.JobPositionDao;
import com.muammerdiri.hrms.entities.concrete.JobPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class JobPositionManager implements JobPositionService {
    private JobPositionDao jobPositionDao;

    @Autowired
    public JobPositionManager(JobPositionDao jobPositionDao) {
        this.jobPositionDao = jobPositionDao;
    }

    @Override
    public List<JobPosition> getAll() {
        return this.jobPositionDao.findAll() ;
    }

    @Override
    public void add(JobPosition jobPosition) {
        this.jobPositionDao.save(jobPosition);
    }

    @Override
    public void update(JobPosition jobPosition) {

    }

    @Override
    public void delete(JobPosition jobPosition) {
        this.jobPositionDao.delete(jobPosition);
    }
}
