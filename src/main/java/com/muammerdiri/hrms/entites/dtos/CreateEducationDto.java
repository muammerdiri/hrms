package com.muammerdiri.hrms.entites.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateEducationDto {
    private float score;
    private String dateOfEntry;
    private String graduateDate;
    private int departmentId;
}
