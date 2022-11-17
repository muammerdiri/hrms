package com.muammerdiri.hrms.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllEmployeeResponse {
    private int id;

    private String firstName;

    private String LastName;

    private int dateOfBirth;

    private String identityNumber;

    private String email;
}
