package com.muammerdiri.hrms.dataAccess.abstracts;

import com.muammerdiri.hrms.entites.concretes.Education;
import com.muammerdiri.hrms.entites.dtos.CreateEducationDto;
import com.muammerdiri.hrms.entites.dtos.GetEducationDetailDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EducationRepository extends JpaRepository<Education,Integer> {

    @Query(value = "SELECT new com.muammerdiri.hrms.entites.dtos.GetEducationDetailDto" +
            "(e.id,f.name,s.name,d.name,e.score,e.dateOfEntry,e.graduateDate)" +
            " FROM Education e INNER JOIN e.department d INNER JOIN e.department.faculity.school s INNER JOIN e.department.faculity f ORDER BY e.graduateDate DESC ")
    List<GetEducationDetailDto> getEducationByGraduateDate();





}
