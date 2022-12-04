package com.muammerdiri.hrms.dataAccess.abstracts;

import com.muammerdiri.hrms.entites.concretes.Cv;
import com.muammerdiri.hrms.entites.dtos.GetCvDetailDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CvRepository extends JpaRepository<Cv,Integer> {

    @Query(value = "SELECT new com.muammerdiri.hrms.entites.dtos.GetCvDetailDto" +
            "(cv.coverLetter, cv.githubAccount,cv.linkedInAccount, em.firstName, em.LastName, em.dateOfBirth , e.department.school.schoolName, " +
            "e.department.name,e.dateOfEntry,e.graduateDate,je.companyName,je.enterDate," +
            "je.finishDate,je.jobPosition.name,i.path,pt.name,pt.programmingLanguage.name,l.name,l.level) " +
            "from Cv cv INNER JOIN cv.employee em INNER JOIN cv.education e INNER JOIN cv.jobExperience je INNER JOIN cv.image i INNER JOIN cv.programmingTechnology pt INNER JOIN cv.language l")
    List<GetCvDetailDto> getAll();

	
    @Query(value = "SELECT new com.muammerdiri.hrms.entites.dtos.GetCvDetailDto" +
            "(cv.coverLetter, cv.githubAccount,cv.linkedInAccount, em.firstName, em.LastName, em.dateOfBirth , e.department.school.schoolName, " +
            "e.department.name,e.dateOfEntry,e.graduateDate,je.companyName,je.enterDate," +
            "je.finishDate,je.jobPosition.name,i.path,pt.name,pt.programmingLanguage.name,l.name,l.level) " +
            "from Cv cv INNER JOIN cv.employee em INNER JOIN cv.education e INNER JOIN cv.jobExperience je INNER JOIN cv.image i INNER JOIN cv.programmingTechnology pt INNER JOIN cv.language l "
            + "Where em.id = :id")
    List<GetCvDetailDto> findByEmployeeId(int id);


    
}
