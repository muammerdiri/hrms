package com.muammerdiri.hrms.entites.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateEducationDto {
    private float score;
    private String dateOfEntry;
    private String graduateDate;
    private int school_id;
    private int faculty_id;
    private int department_id;
}
