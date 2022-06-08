package com.muammerdiri.hrms.dataAccess.abstracts;

import com.muammerdiri.hrms.entities.concrete.JobPosition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobPositionDao extends JpaRepository<JobPosition,Integer> {
}
