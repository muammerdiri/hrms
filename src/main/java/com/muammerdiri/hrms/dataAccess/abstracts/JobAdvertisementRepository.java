package com.muammerdiri.hrms.dataAccess.abstracts;

import com.muammerdiri.hrms.core.utilities.results.DataResult;
import com.muammerdiri.hrms.entites.concretes.JobAdvertisement;
import net.bytebuddy.TypeCache;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JobAdvertisementRepository extends JpaRepository<JobAdvertisement,Integer> {

    List<JobAdvertisement> findAllByStatusTrue();

}
