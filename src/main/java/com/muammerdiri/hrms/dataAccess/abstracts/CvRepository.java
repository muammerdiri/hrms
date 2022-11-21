package com.muammerdiri.hrms.dataAccess.abstracts;

import com.muammerdiri.hrms.entites.concretes.Cv;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CvRepository extends JpaRepository<Cv,Integer> {

}
