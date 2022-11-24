package com.muammerdiri.hrms.dataAccess.abstracts;

import com.muammerdiri.hrms.entites.concretes.JobAdvertisement;
import com.muammerdiri.hrms.entites.dtos.GetJobAdvertisementDetailsDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface JobAdvertisementRepository extends JpaRepository<JobAdvertisement,Integer> {

    @Query(value = "SELECT new com.muammerdiri.hrms.entites.dtos.GetJobAdvertisementDetailsDto(ja.title,jb.name,ja.numberOfPosition,ja.lastDate,ja.releaseDate,c.name) " +
            "FROM JobAdvertisement ja INNER JOIN ja.city c INNER JOIN ja.jobPosition jb  WHERE ja.lastDate>=:date and ja.status = true ")
    List<GetJobAdvertisementDetailsDto> findAllByLastDate(@Param("date") LocalDate date);


    @Query(value = "Select new com.muammerdiri.hrms.entites.dtos.GetJobAdvertisementDetailsDto (ja.title,jb.name,ja.numberOfPosition,ja.lastDate,ja.releaseDate,c.name)" +
            " from JobAdvertisement ja inner join ja.city c INNER JOIN ja.jobPosition jb " )
    List<GetJobAdvertisementDetailsDto> getJobAdvertisementWithCityAndPosition();




}
