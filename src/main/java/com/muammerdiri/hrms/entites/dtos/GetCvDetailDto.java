package com.muammerdiri.hrms.entites.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCvDetailDto {

    private String coverLetter;
    private String githubAccount;
    private String linkedInAccount;
    
    //Employee
    private String firstName;
    private String lastName;
    private int dateOfBirth;

    

    //Education
    private String educationSchoolName;
    private String educationDepartmentName;
    private LocalDate educationDateOfEntered;
    private LocalDate educationGraduateDate;

    // JobExperience
    private String jobExperienceCompanyName;
    private LocalDate jobExperienceCompanyDateOfEntered;
    private LocalDate jobExperienceCompanyDateOfFinished;
    private String jobPositionName;
//    // Image
    private String imagePath;

//    //ProgrammingTechnology
    private String technologyName;
    private String programmingLanguageName;

//    //Language
    private String languageName;
    private int languageLevel;
    
    




}
