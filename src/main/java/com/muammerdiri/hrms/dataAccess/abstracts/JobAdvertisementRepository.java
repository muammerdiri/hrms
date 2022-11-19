package com.muammerdiri.hrms.dataAccess.abstracts;

import com.muammerdiri.hrms.core.utilities.results.DataResult;
import com.muammerdiri.hrms.entites.concretes.JobAdvertisement;
import net.bytebuddy.TypeCache;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface JobAdvertisementRepository extends JpaRepository<JobAdvertisement,Integer> {

    List<JobAdvertisement> findAllByStatusTrue();

    @Query(value = "SELECT * FROM job_advertisements  ja WHERE ja.last_date >= :date AND status = true",nativeQuery = true)
    List<JobAdvertisement> findAllByLastDate(@Param("date") LocalDate date);

}
