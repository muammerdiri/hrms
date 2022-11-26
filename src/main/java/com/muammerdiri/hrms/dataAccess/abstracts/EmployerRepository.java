package com.muammerdiri.hrms.dataAccess.abstracts;

import com.muammerdiri.hrms.entites.dtos.GetEmployerDetailDto;
import org.springframework.data.jpa.repository.JpaRepository;

import com.muammerdiri.hrms.entites.concretes.Employer;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployerRepository extends JpaRepository<Employer, Integer>{

    @Query(value ="SELECT new com.muammerdiri.hrms.entites.dtos.GetEmployerDetailDto" +
            "(e.id,u.email,e.companyName,e.website,e.phoneNumber)" +
            "FROM Employer e INNER JOIN e.user u" )
    List<GetEmployerDetailDto> getAll();
}
