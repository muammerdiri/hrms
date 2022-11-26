package com.muammerdiri.hrms.dataAccess.abstracts;

import com.muammerdiri.hrms.entites.concretes.Employee;
import com.muammerdiri.hrms.entites.dtos.GetEmployeeDetailDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    @Query(value = "SELECT new com.muammerdiri.hrms.entites.dtos.GetEmployeeDetailDto" +
            "(e.id,e.firstName,e.LastName,e.identityNumber,e.dateOfBirth,u.email) " +
            "FROM Employee e INNER JOIN e.user u")
    List<GetEmployeeDetailDto> getAll();
}
