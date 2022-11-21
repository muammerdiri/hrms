package com.muammerdiri.hrms.business.requests.cv;

import com.muammerdiri.hrms.entites.concretes.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCvRequest {

    // Employee
    private int employeeId;
    private String firstName;
    private String lastName;
    private int dateOfBirth;
    private String identityNumber;

    // Cv
    private String coverLetter;
    private String linkedInAccount;
    private String githubAccount;

    // School
    private String schoolName;
    private String schoolDepartment;
    private String schoolEnterDate;
    private String graduateDate;

    // JobExperience
    private String companyName;
    private String positionName; // JobPosition
    private String jobEnterDate;
    private String jobFinishDate;

    // Language
    private String languageName;
    private short languageLevel;

    // ProgrammingTechnology
    private String programmingName; // ProgrammingLangugage
    private String programmingTechnonlogy;

    // Image
    private String imageName;
    private String imagePath;
    private String imageCreateDate;
}
