package com.muammerdiri.hrms.entites.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetEmployerDetailDto {
    private int id;
    private String email;
    private String companyName;
    private String website;
    private String phoneNumber;
}
