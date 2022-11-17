package com.muammerdiri.hrms.dataAccess.abstracts;

import com.muammerdiri.hrms.entites.concretes.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {



}
