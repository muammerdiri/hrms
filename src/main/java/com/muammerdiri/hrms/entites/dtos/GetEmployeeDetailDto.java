package com.muammerdiri.hrms.entites.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetEmployeeDetailDto {
    private int id;
    private String firstName;
    private String lastName;
    private String identityNumber;
    private int dateOfBirth;
    private String email;

}
