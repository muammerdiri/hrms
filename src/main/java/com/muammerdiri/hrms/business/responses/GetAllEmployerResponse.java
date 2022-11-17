package com.muammerdiri.hrms.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetAllEmployerResponse {
    private int id;
    private String email;
    private String companyName;
    private String website;
    private String phoneNumber;
}
