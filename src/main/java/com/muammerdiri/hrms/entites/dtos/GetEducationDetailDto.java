package com.muammerdiri.hrms.entites.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetEducationDetailDto {

    private int id;
    private String schoolName;
    private String facultyName;
    private String departmentName;
    private float score;
    private LocalDate dateOfEntry;
    private LocalDate graduateDate;



}
